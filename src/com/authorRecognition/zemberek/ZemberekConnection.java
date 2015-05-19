package com.authorRecognition.zemberek;

import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.HarfDizisi;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.Kok;
import net.zemberek.yapi.ek.Ek;

public class ZemberekConnection {

    @SuppressWarnings("FieldMayBeFinal")
    private Zemberek zemberek;
    private Kelime[] solutions;
    private Kelime choosedWord;

    public ZemberekConnection() {
        zemberek = new Zemberek(new TurkiyeTurkcesi());
    }

    public String getRoot(String word) {
        solutions = zemberek.kelimeCozumle(word);
        if (solutions.length != 0) {
            choosedWord = solutions[0];
        } else {
            choosedWord = new Kelime(Kok.BOS_KOK, HarfDizisi.BOS_DIZI);
        }
        
        return choosedWord.kok().icerik();
    }
    
    public String[] getRoots(String word) {
        Kok[] kokList = zemberek.kokBulucu().kokBul(word);
        String[] roots = new String[kokList.length];
        for(int i=0; i<kokList.length; i++){
            roots[i] = kokList[i].icerik();
        }
        
        return roots;
    }

    public String getRootType(String word) {
        solutions = zemberek.kelimeCozumle(word);
        if(solutions.length == 0){
            return new Kelime(Kok.BOS_KOK, HarfDizisi.BOS_DIZI).kok().tip().name();
        }

        return solutions[0].kok().tip().name();
    }
    
    public String[] getRootTypes(String word) {
        Kok[] kokList = zemberek.kokBulucu().kokBul(word);
        String[] rootTypes = new String[kokList.length];
        for(int i=0; i<kokList.length; i++){
            rootTypes[i] = kokList[i].tip().name();
        }
        
        return rootTypes;
    }

    public boolean isTurkish(String word) {
        return zemberek.kelimeDenetle(word);
    }
    
    public Kelime[] parse(String word) {
        return zemberek.kelimeCozumle(word);
    }
    
    public Ek[] getInsets(Kelime word) {
        return word.ekDizisi();
    }
    
    public int getInsetCount(Kelime word) {
        return word.ekDizisi().length;
    }
    
    public int getWordLength(Kelime word) {
        return word.boy();
    }
    
    public int getRootFrekans(Kelime word) {
        return word.kok().getFrekans();
    }
}
