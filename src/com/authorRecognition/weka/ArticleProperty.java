package com.authorRecognition.weka;

import java.util.ArrayList;
import java.util.List;

public class ArticleProperty {
    
    private int id;
    private String author;
    private List<String> properties;    
    private List<String> values;

    public ArticleProperty() {
        this.properties = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public ArticleProperty(String author, List<String> properties, List<String> values) {
        this.author = author;
        this.properties = properties;
        this.values = values;
    }
    
    public int getId() {
        return id;
    }

    public List<String> getProperties() {
        return properties;
    }
    
    public String getProperty(int index) {
        return properties.get(index);
    }

    public List<String> getValues() {
        return values;
    }
    
    public String getValue(int index) {
        return values.get(index);
    }
    
    public String getValue(String key) {
        for (int i = 0; i < properties.size(); i++) {
            if(properties.get(i).contains(key)){
                return values.get(i);
            }
        }
        
        return "0.0";
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    
    public void addProperty(String property) {
        this.properties.add(property);
    }

    public void addValue(String value) {
        this.values.add(value);
    }
}
