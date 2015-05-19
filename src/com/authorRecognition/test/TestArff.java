package com.authorRecognition.test;

import com.authorRecognition.weka.Arff;
import com.authorRecognition.weka.Attribute;
import com.authorRecognition.weka.Data;
import java.util.ArrayList;
import java.util.List;

public class TestArff {
    
    public static void main(String[] args) {
        List<String> values1 = new ArrayList<>();
        values1.add("v1");
        values1.add("v2");
        values1.add("v3");

        List<String> values2 = new ArrayList<>();
        values2.add("v4");
        values2.add("v5");

        List<String> values3 = new ArrayList<>();
        values3.add("REAL");
        
        List<String> values = new ArrayList<>();
        values.add("class1");
        values.add("class2");
        values.add("class3");

        List<Attribute> attributeList = new ArrayList<>();
        attributeList.add(new Attribute("att1", values1));
        attributeList.add(new Attribute("att2", values2));
        attributeList.add(new Attribute("att3", values3));
        attributeList.add(new Attribute("class", values));

        List<String> values4 = new ArrayList<>();
        values4.add("v1");
        values4.add("v4");
        values4.add("1.7");

        List<String> values5 = new ArrayList<>();
        values5.add("v3");
        values5.add("v4");
        values5.add("3.7");

        List<String> values6 = new ArrayList<>();
        values6.add("v2");
        values6.add("v5");
        values6.add("0.9");

        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data("class1", values4));
        dataList.add(new Data("class2", values5));
        dataList.add(new Data("class3", values6));

        Arff.writeToArffFile("C:\\Users\\erdem_000\\Desktop\\textFile.arff", "textFile", attributeList, dataList);
    }
    
}
