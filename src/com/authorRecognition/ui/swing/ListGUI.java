package com.authorRecognition.ui.swing;

import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ListGUI {
    
    private JList list;

    public ListGUI(JList list) {
        this.list = list;
    }
    
    public String[] getContent(){
        DefaultListModel model = (DefaultListModel) list.getModel();
        String[] tl = new String[model.getSize()];
        for (int i = 0; i < model.getSize(); i++) {
            tl[i] = (String)model.getElementAt(i);
        }
        
        return tl;
    }
    
    public void setContent(String[] content){
        list.setListData(content);
    }
    
    public String getRow(int index){
        return (String)list.getSelectedValue();
    } 
    
    public void addRow(String row){
        DefaultListModel model = (DefaultListModel) list.getModel();
        model.addElement(row);
        list.setModel(model);
    }
    
    public void deleteRow(int index){
        DefaultListModel model = (DefaultListModel) list.getModel();
        model.removeElementAt(index);
        list.setModel(model);
    }
    
    public int getSelectedIndex(int index){
        return list.getSelectedIndex();
    }
    
    public int[] getSelectedIndexs(int index){
        return list.getSelectedIndices();
    }
    
    public String getSelectedRow(int index){
        return (String)list.getSelectedValue();
    }
    
    public void clear(){
        DefaultListModel model = (DefaultListModel) list.getModel();
        model.clear();
        list.setModel(model);
    }
    
    public int size(){
        DefaultListModel model = (DefaultListModel) list.getModel();
        return model.getSize();
    }
    
    public boolean isEmpty(){
        DefaultListModel model = (DefaultListModel) list.getModel();
        return model.getSize() == 0;
    }
    
    public String[] prepareListContent(List<String> content){
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
        list.setEnabled(newEnable);
    }
    
    public boolean isEnable(){
        return list.isEnabled();
    }
    
}
