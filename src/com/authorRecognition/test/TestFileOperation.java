package com.authorRecognition.test;

import com.authorRecognition.zemberek.Article;
import com.authorRecognition.db.FileOperation;
import com.authorRecognition.zemberek.ArticleType;
import java.io.IOException;
import java.util.List;

public class TestFileOperation {
    
    private static final String path = "C:\\Users\\erdem_000\\Desktop\\Bitirme Projesi\\MAKALELER\\Makaleler\\ekumcu";
    
    public static void main(String[] args) throws IOException, Exception {
        testReadArticles();
        testWriteToDatabase();
    }
    
    private static void testReadArticles() throws IOException {
        List<Article> articleList = FileOperation.readArticles(path);
        System.out.println("Article size " + articleList.size());
        for(Article a : articleList)
            System.out.println(a);
    }
    
    private static void testWriteToDatabase() throws IOException, Exception {
        List<Article> articleList = FileOperation.readArticles(path);
        FileOperation.writeToDatabase(articleList, ArticleType.GENEL, "ERDEM BİNGÖL");
    }
            
}
