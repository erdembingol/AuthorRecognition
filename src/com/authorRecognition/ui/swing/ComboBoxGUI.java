package com.authorRecognition.ui.swing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;

public class ComboBoxGUI {
    
    private JComboBox comboBox;

    public ComboBoxGUI(JComboBox comboBox) {
        this.comboBox = comboBox;
    }
    
    public Set<String> getContent(){
        Set<String> set = new HashSet<>();
        for(int i=0; i<comboBox.getModel().getSize(); i++)
            set.add(comboBox.getModel().getElementAt(i).toString());
        
        return set;
    }
    
    public void setContent(Set<String> content){
        Iterator it = content.iterator();
        while(it.hasNext()){
            comboBox.addItem(it.next());
        }
    }
    
    public String getRow(int index){
        String cl;
        cl = comboBox.getModel().getElementAt(index).toString();
        
        return cl;
    } 
    
    public void addRow(String row){
        comboBox.addItem(row);
    }
    
    public void deleteRow(int index){
        comboBox.remove(index);
    }
    
    public int getSelectedIndex(){
        return comboBox.getSelectedIndex();
    }
    
    public String getSelectedRow(){
        return comboBox.getSelectedItem().toString();
    }
    
    public void clear(){
        int itemCount = comboBox.getItemCount();
        for(int i=0;i<itemCount;i++){
            comboBox.removeItemAt(0);
        }
    }
    
    public int size(){
        return comboBox.getSelectedObjects().length;
    }
    
    public boolean isEmpty(){
        return comboBox.getSelectedObjects().length == 0;
    }
    
    public String[] prepareComboBoxContent(List<String> content){
        if(content == null){
            return null;
        }
        String[] sonuc = new String[content.size()];       

        for(int i=0; i<content.size(); i++){
            sonuc[i] = content.get(i);
        }

        return sonuc;
    }
    
    public void enable(boolean newEnable){
        comboBox.setEnabled(newEnable);
    }
    
    public boolean isEnable(){
        return comboBox.isEnabled();
    }
    
    public void editable(boolean newEnable){
        comboBox.setEditable(newEnable);
    }
    
    public boolean isEditable(){
        return comboBox.isEditable();
    }
    
}
