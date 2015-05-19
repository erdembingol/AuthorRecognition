package com.authorRecognition.zemberek;

import java.util.HashSet;
import java.util.Set;

public enum SentenceType {
    
    QUESTION("QUESTION"), EXCLAMATION("EXCLAMATION"), POSITIVE("POSITIVE"), NEGATIF("NEGATIF"), 
    REGULAR("REGULAR"), INVERSE("INVERSE"), VERB("VERB"), NOUN("NOUN"), SIMPLE("SIMPLE"), UNIFIED("UNIFIED");
    
    private final String name;

    private SentenceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public Set<String> getSentenceTypes() {
        Set<String> types = new HashSet<>();
        types.add(VERB.getName());
        types.add(NOUN.getName());
        types.add(QUESTION.getName());
        types.add(EXCLAMATION.getName());
        types.add(POSITIVE.getName());
        types.add(NEGATIF.getName());
        types.add(REGULAR.getName());
        types.add(INVERSE.getName());
        types.add(SIMPLE.getName());
        types.add(UNIFIED.getName());
        
        return types;
    }


    @Override
    public String toString() {
        return name;
    }
    
}
