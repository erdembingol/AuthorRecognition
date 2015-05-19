package com.authorRecognition.zemberek;

import java.util.HashSet;
import java.util.Set;

public enum MarkType {
    
    POINT("POINT"), COMMA("COMMA"), COLON("COLON"), SEMICOLON("SEMICOLON"), QUESTION_MARK("QUESTION_MARK"), HYPEN("HYPEN"), 
    EXCLAMATION_MARK("EXCLAMATION_MARK"), PARANTHESIS("PARANTHESIS"), QUOTATION("QUOTATION"), ELLIPSIS_POINT("ELLİPSIS_POINT");
    
    private final String name;

    private MarkType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public Set<String> getMarkTypes() {
        Set<String> types = new HashSet<>();
        types.add(POINT.getName());
        types.add(COMMA.getName());
        types.add(COLON.getName());
        types.add(SEMICOLON.getName());
        types.add(QUESTION_MARK.getName());
        types.add(HYPEN.getName());
        types.add(EXCLAMATION_MARK.getName());
        types.add(PARANTHESIS.getName());
        types.add(QUOTATION.getName());
        types.add(ELLIPSIS_POINT.getName());
        
        return types;
    }


    @Override
    public String toString() {
        return name;
    }
    
}
