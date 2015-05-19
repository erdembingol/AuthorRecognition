package com.authorRecognition.test;

import com.authorRecognition.zemberek.Article;
import com.authorRecognition.zemberek.ArticleType;
import com.authorRecognition.zemberek.MarkType;
import com.authorRecognition.zemberek.SentenceType;
import com.authorRecognition.zemberek.WordType;
import com.authorRecognition.zemberek.ArticleOperation;
import com.authorRecognition.zemberek.ZemberekConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;

public class TestArticleOperation {

    private static final String path = "C:\\Users\\erdem_000\\Desktop\\Bitirme Projesi\\MAKALE\\Train&Test_50\\AHMET ÇAKAR\\14.txt";
    private static Article article;

    public static void main(String[] args) throws SQLException, Exception {
        testAll();
    }

    private static void testAll() throws IOException {
        article = new Article("Erdem", readArticle(path), ArticleType.GENEL);       
        ArticleOperation ao = new ArticleOperation(article);
        List<String> nums = ao.getTimes();
        for (int i = 0; i < nums.size(); i++) {
            System.err.println(nums.get(i));
        }
//        
//        ZemberekConnection zc = new ZemberekConnection();
//        String[] list = zc.getRoots("hükümet");
//        boolean res = ao.isTime("hükümet", list);
//        System.err.println(res);
//        List<String> sentences;
//
//        sentences = ao.getSentences(SentenceType.EXCLAMATION);
//        System.out.println("EXCLAMATION Sentences :" + sentences.size());
//        System.out.println();
//        for (String sentence : sentences) {
//            System.out.println(sentence);
//        }
//        System.out.println("*************************************************");
//
//        sentences = ao.getSentences(SentenceType.VERB);
//        System.out.println("VERB Sentences :" + sentences.size());
//        System.out.println();
//        for (String sentence : sentences) {
//            System.out.println(sentence);
//        }
//        System.out.println("*************************************************");
//
//        sentences = ao.getSentences(SentenceType.INVERSE);
//        System.out.println("INVERSE Sentences :" + sentences.size());
//        System.out.println();
//        for (String sentence : sentences) {
//            System.out.println(sentence);
//        }
//        System.out.println("*************************************************");
//
//        
//        List<String> words = ao.getWords(WordType.ABBREVIATION);
//        System.out.println("ABBREVIATION " + words.size());
//        System.out.println();
//        for (int i = 0; i < words.size(); i++) {
//            System.out.println(words.get(i));
//        }
//        System.out.println("*************************************************");
//
//        
//        System.out.println("MARK Count is " + ao.getMarkCount());
//        System.out.println("POINT Count is " + ao.getMarkCount(MarkType.POINT));
//        System.out.println("COMMA Count is " + ao.getMarkCount(MarkType.COMMA));
//        System.out.println("COLON Count is " + ao.getMarkCount(MarkType.COLON));
//        System.out.println("ELLİPSIS_POINT Count is " + ao.getMarkCount(MarkType.ELLIPSIS_POINT));
//        System.out.println("EXCLAMATION_MARK Count is " + ao.getMarkCount(MarkType.EXCLAMATION_MARK));
//        System.out.println("HYPEN Count is " + ao.getMarkCount(MarkType.HYPEN));
//        System.out.println("QUOTATION Count is " + ao.getMarkCount(MarkType.QUOTATION));
//        System.out.println("SEMICOLON Count is " + ao.getMarkCount(MarkType.SEMICOLON));
//
//        
//        System.out.println("Average sentences length is " + Math.floor(ao.getAverageSentencesLength()));
    }

    private static String readArticle(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        if (!file.exists()) {
            System.err.println("Path not found");
            System.exit(1);
        }

        /* Makale içeriğini hazırla */
        FileInputStream fr = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fr, Charset.forName("ISO-8859-9"));
        BufferedReader bfr = new BufferedReader(isr);
        String line;
        StringBuilder text = new StringBuilder();
        while ((line = bfr.readLine()) != null) {
            if(line.contains("*") || line.equals("\n")){
                continue;
            }
            
            text.append(line);
            text.append('\n');
        }
        String content = text.toString();
        
        return content;
    }

}
