package com.authorRecognition.weka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Arff {
    
    public static void writeToArffFile(String filePath, String relationName, List<Attribute> attributeList, List<Data> dataList) {
        try {
            File file = new File(filePath);
            FileWriter outFile = new FileWriter(file);
            try (PrintWriter out = new PrintWriter(outFile)) {
                //Relation name print
                out.println("@RELATION " + relationName);
                out.println();
                                                
                //Attribute list print 
                for (int i = 0; i < attributeList.size(); i++) {
                    if(attributeList.get(i).getValues().size() == 1){
                        if(i == attributeList.size()-1){
                            out.println("@ATTRIBUTE " + attributeList.get(i).getName() + " {" + attributeList.get(i).getValue(0) + "}");
                        }else{
                            out.println("@ATTRIBUTE " + attributeList.get(i).getName() + " " + attributeList.get(i).getValue(0));
                        }   
                    }else{
                        out.print("@ATTRIBUTE " + attributeList.get(i).getName() + " " + "{");
                        for (int j = 0; j < attributeList.get(i).getValues().size()-1; j++) {
                            out.print(attributeList.get(i).getValue(j) + ",");
                        }
                        out.println(attributeList.get(i).getValue(attributeList.get(i).getValues().size()-1) + "}");
                    }
                }
                out.println();
                
                //Data list print
                out.println("@DATA");
                for (int i = 0; i < dataList.size(); i++) {
                    for (int j = 0; j < dataList.get(i).getValues().size(); j++) {
                        out.print(dataList.get(i).getValue(j) + ",");
                    }
                    out.println(dataList.get(i).getClassName());
                }
                
                out.close();
            }
        } catch (IOException e) {
            System.err.println("Hata: " + e.getMessage());
        }
    }
    
}
