package com.authorRecognition.test;

import com.authorRecognition.db.DatabaseOperation;
import com.authorRecognition.zemberek.Article;
import com.authorRecognition.zemberek.ArticleType;
import java.util.List;

public class TestDatabaseOperation {
    
    private static final Article article = new Article("Erdem", "asdadads adsasds, asdasdasd..asd.a ! sdfsdf ? asdfasdsdfsdfdfg", ArticleType.DUNYA);
    
    public static void main(String[] args) throws Exception {
//        testClearAllTables();
        testClearTable();
//        testArticleSave();        
//        testArticleDelete();        
//        testGetAllArticles();        
    }
    
    private static void testClearAllTables() throws Exception {
        DatabaseOperation db = new DatabaseOperation(); 
        db.connect();
        db.clearAllTables();
        db.disconnect();
    }
    
    private static void testClearTable() throws Exception {
        DatabaseOperation db = new DatabaseOperation(); 
        db.connect();
        db.clearTable("Article");
        db.disconnect();
    }
    
    private static void testArticleSave() throws Exception {        
        DatabaseOperation db = new DatabaseOperation(); 
        db.connect();
        db.articleSave(article);
        db.disconnect();
    }
    
    private static void testArticleDelete() throws Exception {
        DatabaseOperation db = new DatabaseOperation(); 
        db.connect();
        db.articleDelete(59);
        db.disconnect();
    }
    
    private static void testGetAllArticles() throws Exception {
        DatabaseOperation db = new DatabaseOperation(); 
        db.connect();
        List<Article> articles = db.getAllArticles();
        for(Article a : articles){
            System.out.println(a);
        }
        db.disconnect();
    }
    
}
