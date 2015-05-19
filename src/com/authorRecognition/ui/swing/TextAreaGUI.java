package com.authorRecognition.ui.swing;

import javax.swing.JTextArea;

public class TextAreaGUI {
    
    private JTextArea textArea;

    public TextAreaGUI(JTextArea textArea) {
        this.textArea = textArea;
    }
    
    public String getText(){
        return textArea.getText();
    }
    
    public void setText(String text){
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(text);
    }
    
    public boolean isEmpty(){
        return textArea.getText().equals("");
    }
    
    public void clear(){
        textArea.setText("");
    }
    
    public int length(){
        return textArea.getText().length();
    }
    
    public void enable(boolean newEnable){
        textArea.setEnabled(newEnable);
    }
    
    public boolean isEnable(){
        return textArea.isEnabled();
    }
    
    public void editable(boolean newEnable){
        textArea.setEditable(newEnable);
    }
    
    public boolean isEditable(){
        return textArea.isEditable();
    }
    
}
