package com.authorRecognition.zemberek;

import java.util.HashSet;
import java.util.Set;

public enum ArticleType {
  
    DUNYA("DÜNYA"), SPOR("SPOR"), EKONOMI("EKONOMİ"), GUNDEM("GÜNDEM"), SIIR("ŞİİR"), TARIH("TARİH"),SAGLIK("SAĞLIK"), GENEL("GENEL");
    
    private final String name;

    private ArticleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public Set<String> getTypes() {
        Set<String> types = new HashSet<>();
        types.add(DUNYA.getName());
        types.add(EKONOMI.getName());
        types.add(GENEL.getName());
        types.add(GUNDEM.getName());
        types.add(SPOR.getName());
        types.add(TARIH.getName());
        types.add(SIIR.getName());
        types.add(SAGLIK.getName());
        
        return types;
    }

    @Override
    public String toString() {
        return name;
    }
}
