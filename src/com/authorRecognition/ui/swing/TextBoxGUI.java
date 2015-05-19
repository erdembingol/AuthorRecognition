package com.authorRecognition.ui.swing;

import javax.swing.JTextField;

public class TextBoxGUI {
    
    private JTextField textField = new JTextField();

    public TextBoxGUI(JTextField textField) {
       this.textField = textField;
    }
    
    public String getText(){
        return textField.getText();
    }
    
    public void setText(String text){
        textField.setText(text);
    }
    
    public boolean isEmpty(){
        return textField.getText().equals("");
    }

    public void clear(){
        textField.setText("");
    }
    
    public int length(){
        return textField.getText().length();
    }
    
    public void enable(boolean newEnable){
        textField.setEnabled(newEnable);
    }
    
    public boolean isEnable(){
        return textField.isEnabled();
    }
    
    public void editable(boolean newEnable){
        textField.setEditable(newEnable);
    }
    
    public boolean isEditable(){
        return textField.isEditable();
    }
}
