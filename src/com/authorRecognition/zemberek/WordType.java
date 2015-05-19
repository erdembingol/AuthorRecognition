package com.authorRecognition.zemberek;

import java.util.HashSet;
import java.util.Set;

public enum WordType {
    
    VERB("VERB"), NOUN("NOUN"), ADJECTIVE("ADJECTIVE"), PRONOUN("PRONOUN"), QUESTION_WORD("QUESTION_WORD"),
    PREPOSITION("PREPOSITION"), CONNECTIVE("CONNECTIVE"), ERROR_WORD("ERROR_WORD"), ABBREVIATION("ABBREVIATION"), 
    PROPER_NOUN("PROPER_NOUN"), NUMBER("NUMBER"), EXCLAMATION("EXCLAMATION"), AMPUTATION("AMPUTATION"), TIME("TIME");
    
    private final String name;

    private WordType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public Set<String> getWordTypes() {
        Set<String> types = new HashSet<>();
        types.add(VERB.getName());
        types.add(NOUN.getName());
        types.add(ADJECTIVE.getName());
        types.add(PRONOUN.getName());
        types.add(QUESTION_WORD.getName());
        types.add(PREPOSITION.getName());
        types.add(CONNECTIVE.getName());
        types.add(ERROR_WORD.getName());
        types.add(ABBREVIATION.getName());
        types.add(PROPER_NOUN.getName());
        types.add(NUMBER.getName());
        types.add(EXCLAMATION.getName());
        types.add(AMPUTATION.getName());
        types.add(TIME.getName());
        
        return types;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
