package com.authorRecognition.weka;

import java.util.List;

public class Attribute {
    
    private String name;
    private List<String> values;

    public Attribute(String name, List<String> values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public List<String> getValues() {
        return values;
    }
    
    public String getValue(int index) {
        return values.get(index);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    
    public void addValue(String value) {
        this.values.add(value);
    }
}
