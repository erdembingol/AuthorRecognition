package com.authorRecognition.weka;

import java.util.List;

public class Data {
    
    private String classValue;
    private List<String> values;

    public Data(String className, List<String> values) {
        this.classValue = className;
        this.values = values;
    }

    public String getClassName() {
        return classValue;
    }

    public List<String> getValues() {
        return values;
    }
    
    public String getValue(int index) {
        return values.get(index);
    }

    public void setClassValue(String classValue) {
        this.classValue = classValue;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    
    public void addValue(String value) {
        this.values.add(value);
    }
}
