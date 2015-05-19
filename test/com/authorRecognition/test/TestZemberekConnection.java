/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.authorRecognition.test;

import com.authorRecognition.zemberek.ZemberekConnection;
import java.util.List;
import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.Kok;
import net.zemberek.yapi.ek.Ek;

/**
 *
 * @author erdem_000
 */
public class TestZemberekConnection {
    
    private static final ZemberekConnection zb = new ZemberekConnection();
    private static final Zemberek zemberek = new Zemberek(new TurkiyeTurkcesi());

    public static void main(String[] args) {        
        
        testFindRootAndRootType();
        //testIsTurkish();               
        //test();
        
    }
    
    private static void testFindRootAndRootType() {
        String root = zb.getRoot("sitesidir");
        System.out.println("Kök : " + root);
        
        String rootType = zb.getRootType("sitesidir");
        System.out.println("Kök tipi : " + rootType);
        
        Kok[] kokList = zemberek.kokBulucu().kokBul("sitesidir");
        for (int i = 0; i < kokList.length; i++) {
            System.out.println("Kok -> " + kokList[i].icerik());
        }
        
        String[] roots = zb.getRoots("sitesidir");
        for(String s : roots){
            System.out.println("Kök " + s);
        }
        
        String[] rootTypes = zb.getRootTypes("sitesidir");
        for(String s : rootTypes){
            System.out.println("Kök tipi " + s);
        }
        
        Kelime[] parsed = zb.parse("gider");
        //System.out.println("Word length " + zb.getWordLength(parsed[0]));
        
        //System.out.println("Root Frekans " + zb.getRootFrekans(parsed[0]));
        
        Ek[] insets = zb.getInsets(parsed[0]);
        for(Ek e : insets){
            System.out.println("Ek " + e.ad());
        }
        System.out.println("Ek count " + zb.getInsetCount(parsed[0]));
        
    }
    
    private static void testIsTurkish() {
        if(zb.isTurkish("Prof")){
            System.out.println("kalem türkçe");
        }
        
        if(zb.isTurkish("Arş")){
            System.out.println("asd türkçe");
        }
    }
    
    private static void test() {
        /*
            Kelimeyi kök ve eklerine ayırıyor,farklı şekillerde(Demoda ayrıştır işleminin karşılığı).
        */
        List<String[]> words = zemberek.kelimeAyristir("arabanınki");
        for(int i = 0; i<words.size(); i++){
            String[] temp = words.get(i);
            for(int j = 0; j<temp.length; j++){
                System.out.print(temp[j] + " ");
            }
            System.out.println("");
        }
        
        /*
            Kelimenin olası bütün kök ve ek durumlarını buluyor ve üzerinde işlem yapma olanağı sağlıyor. 
        */
        Kelime[] wordList = zemberek.kelimeCozumle("kimlerdensin");
        int index = 0;
        for(Kelime word : wordList){
            index++;
            System.out.println("Kelime " + index + " : " + word.icerikStr());
            System.out.println("Boy" + word.boy());
            System.out.println("Ek sayısı" + word.ekSayisi());
            System.out.println("Kök" + word.kok().icerik());
            System.out.println("Kök frekans" + word.kok().getFrekans());
            System.out.println("Kök index" + word.kok().getIndeks());
            System.out.println("Kök tipi" + word.kok().tip().name());
            System.out.println("Özel durum" + word.kok().yapiBozucuOzelDurumVarmi());
            System.out.println("Ek zinciri" + word.ekZinciriStr());
        }
        System.out.println("Bitti...");
    }
}
