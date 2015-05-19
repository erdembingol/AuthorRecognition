package com.authorRecognition.ui.swing;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JavaPrepare {
    
    public Object[][] tableVeriHazirla(List<Object> list, int colon_number){
        if(list == null){
            return null;
        }
        Object[][] sonuc = new Object[list.size()][colon_number];       

        for(int i=0;i<list.size();i++){
            sonuc[i][0] = list.get(i); 
            sonuc[i][1] = list.get(i);
            sonuc[i][2] = list.get(i);
        }

        return sonuc;
    }
    
    public Object[] tableBaslikHazirla(List<String> list){
        String[] b = new String[list.size()];
        b[0] = "Etkinlik Adı";
        b[1] = "Etkinlik Türü";
        b[2] = "Etkinlik Tarihi";

        Object[] baslik = b;
        
        return baslik;
    }
    
    public boolean sifreKontrol(String sifre){
        for(int i=0; i<sifre.length(); i++){
            if(sifre.charAt(i) == '\'')
                return false;
        }
        
        return true;
    }
    
    public boolean textfieldsBosmu(List<JTextField> textfields){
        for(int i=0; i<textfields.size(); i++){
            if(textfields.get(i).getText().equals(""))
                return false;
        }
        
        return true;
    }
    
    /*********************** MESSAGE - INPUT - CONFIRM ************************/
    
    public void informationMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void warningMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.WARNING_MESSAGE);
    }
    
    public void errorMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.ERROR_MESSAGE);
    }
    
    public void questionMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.QUESTION_MESSAGE);
    }
    
    public void plainMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.PLAIN_MESSAGE);
    }
    
    public String getInput(String baslik, String text){
        return JOptionPane.showInputDialog(null, text, baslik, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public int getConfirm(String baslik, String text){
        return JOptionPane.showConfirmDialog(null, text, baslik, 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
    }
    
    public int getOption(String baslik, String text, String[] opts, String opt){
        return JOptionPane.showOptionDialog (null, text, baslik, 0, JOptionPane.INFORMATION_MESSAGE, null, opts, opt);
    }
}
