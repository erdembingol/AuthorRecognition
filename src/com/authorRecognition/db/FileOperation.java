package com.authorRecognition.db;

import com.authorRecognition.zemberek.Article;
import com.authorRecognition.zemberek.ArticleType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {
    
    public static List<Article> readArticles(String path) throws FileNotFoundException, IOException {         
        List<Article> articleList = new ArrayList<>();
        read(path, articleList);
        
        return articleList;
    }
    
    public static void writeToDatabase(List<Article> articleList, ArticleType type, String author) throws SQLException, Exception {
        DatabaseOperation db = new DatabaseOperation();
        db.connect();
        for(Article a : articleList){
            a.setType(type);
            a.setAuthor(author);
            db.articleSave(a);
        }
        db.disconnect();
    }
    
    private static void read(String path, List<Article> articleList) throws FileNotFoundException, IOException {
        File file = new File(path);
        if(!file.exists()){
            System.err.println("Path not found");
            System.exit(1);
        }
        
        if(file.isDirectory()){
            String[] fileList = file.list();
            for (String f : fileList) {
                String fileType = f.substring(f.length() - 3);
                if(fileType.equals("txt")){
                    read(path + "\\" + f, articleList);
                }
            }
        }else{
            /* Makale yazarını bul */
            String[] directoryPart = path.split("\\\\");
            String author = directoryPart[directoryPart.length - 2];
            author = author.toUpperCase();
            
            /* Makale içeriğini hazırla */
            FileInputStream fr = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fr,Charset.forName("ISO-8859-9"));
            BufferedReader bfr = new BufferedReader(isr);
            String line;
            StringBuilder text = new StringBuilder();
            while ((line = bfr.readLine()) != null) {
                if(line.contains("*")){
                    continue;
                }
                
                text.append(line);
                text.append('\n');
                  //System.out.println(text.toString());
            }
            String content = text.toString();
            
            /* Makale ekle */
            Article article = new Article(author, content);
            articleList.add(article);
        }
    }
    
}
