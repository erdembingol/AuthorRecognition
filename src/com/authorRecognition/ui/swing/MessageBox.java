package com.authorRecognition.ui.swing;

import javax.swing.JOptionPane;

public class MessageBox {
    
    public static void informationMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void warningMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.WARNING_MESSAGE);
    }
    
    public static void errorMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void questionMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void plainMessage(String baslik, String text){
        JOptionPane.showMessageDialog(null, text, baslik, JOptionPane.PLAIN_MESSAGE);
    }
    
    public static String getInput(String baslik, String text){
        return JOptionPane.showInputDialog(null, text, baslik, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int getConfirm(String baslik, String text){
        return JOptionPane.showConfirmDialog(null, text, baslik, 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
    }
    
    public static int getOption(String baslik, String text, String[] opts, String opt){
        return JOptionPane.showOptionDialog (null, text, baslik, 0, JOptionPane.INFORMATION_MESSAGE, null, opts, opt);
    }
    
}
