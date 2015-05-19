package com.authorRecognition.db;

import com.authorRecognition.zemberek.Article;
import com.authorRecognition.zemberek.ArticleType;
import com.authorRecognition.ui.swing.MessageBox;
import com.authorRecognition.weka.ArticleProperty;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseOperation {

    private Connection con = null;
    @SuppressWarnings("FieldMayBeFinal")
    private String databaseURL;
    @SuppressWarnings("FieldMayBeFinal")
    private String userName;
    @SuppressWarnings("FieldMayBeFinal")
    private String password;
    @SuppressWarnings("FieldMayBeFinal")
    private String[] tableNames = {"Article", "ArticleProperty"};

    public DatabaseOperation() {
        this.databaseURL = "jdbc:mysql://localhost:3306/authorrecognition";
        this.userName = "root";
        this.password = "Erdem_123";
    }

    public DatabaseOperation(String databaseURL, String userName, String password) {
        this.databaseURL = databaseURL;
        this.userName = userName;
        this.password = password;
    }

    public void connect() throws Exception {
        if (con != null) {
            if (con.isClosed() == false) {
                return;
            }
        }

        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(this.databaseURL, this.userName, this.password);
    }

    public void disconnect() throws SQLException {
        if (con != null) {
            if (!con.isClosed()) {
                con.close();
            }
        }
    }

    public void clearAllTables() throws SQLException, Exception {
        for (String s : tableNames) {
            if(isExist(s)){
                clearTable(s);
            }          
        }
    }

    public void clearTable(String tableName) throws SQLException {
        String query = "DELETE FROM " + tableName;
        String trunc = "TRUNCATE TABLE " + tableName;
        try{
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();
            pstmt = con.prepareStatement(trunc);
            pstmt.executeUpdate();
            pstmt.close();
        }catch(SQLException ex){
            MessageBox.warningMessage("", "DB not cleared");
        }
    }

    public boolean isExist(String tableName) throws SQLException {
        DatabaseMetaData dbm = con.getMetaData();
        ResultSet tables = dbm.getTables(null, null, tableName, null);
        if(tables == null){
            return false;
        }
        
        return tables.next();
    }
    
    public int tableSize(String tableName) throws SQLException {
        if(!isExist(tableName))
            return 0;
            
        String query = "SELECT COUNT(*) FROM " + tableName;
        int size = 0;
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            size = rs.getInt(1);
            rs.close();
        } catch (SQLException ex) {
             MessageBox.errorMessage("", "Size not calculated");
        }
        
        return size;
    }

    public void createTable(List<String> list, String tableName) throws SQLException {
        StringBuilder query = new StringBuilder("CREATE TABLE " + tableName + " (id int NOT NULL AUTO_INCREMENT, author VARCHAR(255)");
        for (String s : list) {
            query.append(", ");
            query.append(s);
            query.append(" DOUBLE NOT NULL");
        }
        query.append(", PRIMARY KEY (id)");
        query.append(")");

        PreparedStatement pstmt = con.prepareStatement(query.toString());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void articleDelete(int id) throws SQLException {
        String query = "DELETE FROM Article WHERE ID = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void articleSave(Article a) throws SQLException {
        String article = "INSERT INTO Article VALUES (DEFAULT,?,?,?)";

        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(article);
            pstmt.setString(1, a.getAuthor());
            pstmt.setString(2, a.getContent());
            pstmt.setString(3, a.getType().toString());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            MessageBox.errorMessage("", "Article not saved!!!");
        }
    }

    @SuppressWarnings({"ConvertToTryWithResources", "null"})
    public List<Article> getAllArticles() throws SQLException {
        String query = "SELECT * FROM Article";
        List<Article> articleList = null;
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            articleList = null;
            if (rs.next()) {
                articleList = new ArrayList<>();
            }
            rs.beforeFirst();
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setAuthor(rs.getString("author"));
                a.setContent(rs.getString("content"));
                a.setType(getType(rs.getString("type")));
                articleList.add(a);
            }

            rs.close();
        } catch (SQLException ex) {
             MessageBox.errorMessage("", "Articles not found");
        }

        return articleList;
    }

    public List<ArticleProperty> getAllArticleProperties() throws SQLException {
        String query = "SELECT * FROM ArticleProperty";
        List<ArticleProperty> articlePropertyList = new ArrayList<>();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                ArticleProperty a = new ArticleProperty();
                a.setId(rs.getInt("id"));
                a.setAuthor(rs.getString(2));
                for (int i = 3; i <= md.getColumnCount(); i++) {
                    a.addProperty(md.getColumnName(i));
                    a.addValue(String.valueOf(rs.getDouble(i)));
                }
                articlePropertyList.add(a);
            }

            rs.close();
        } catch (SQLException ex) {
            MessageBox.errorMessage("", "Articles Properties not found");
        }

        return articlePropertyList;
    }
    
    public ArticleProperty getArticleProperty(int index) throws SQLException {
        String query = "SELECT * FROM ArticleProperty WHERE id = ?";
        ArticleProperty articleProperty = new ArticleProperty();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, index);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                articleProperty.setId(rs.getInt("id"));
                articleProperty.setAuthor(rs.getString(2));
                for (int i = 3; i <= md.getColumnCount(); i++) {
                    articleProperty.addProperty(md.getColumnName(i));
                    articleProperty.addValue(String.valueOf(rs.getDouble(i)));
                }
            }

            rs.close();
        } catch (SQLException ex) {
            MessageBox.errorMessage("", "Article Property not found");
        }

        return articleProperty;
    }

    public void articlePropertySave(ArticleProperty ap){
        StringBuilder articleProperty = new StringBuilder("INSERT INTO ArticleProperty VALUES (DEFAULT");
        for (int i = 0; i <= ap.getProperties().size(); i++) {
            articleProperty.append(",?");
        }
        articleProperty.append(")");

        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(articleProperty.toString());
            pstmt.setString(1, ap.getAuthor());

            for (int i = 0; i < ap.getProperties().size(); i++) {
                //System.err.print(ap.getValue(i) + ", ");
                pstmt.setDouble(i+2, Double.parseDouble(String.valueOf(ap.getValue(i))));
            }

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.errorMessage("", "Article Property not saved");
        }
    }
    
    public void articlePropertyDelete(int id) throws SQLException {
        String query = "DELETE FROM ArticleProperty WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private ArticleType getType(String type) {
        switch (type) {
            case "DÜNYA":
                return ArticleType.DUNYA;
            case "SPOR":
                return ArticleType.SPOR;
            case "GÜNDEM":
                return ArticleType.GUNDEM;
            case "EKONOMİ":
                return ArticleType.EKONOMI;
            case "TARİH":
                return ArticleType.TARIH;
            case "ŞİİR":
                return ArticleType.SIIR;
            default:
                return ArticleType.GENEL;
        }
    }

}
