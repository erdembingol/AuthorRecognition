package com.authorRecognition.ui.swing;

import java.text.MessageFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableGUI {

    private JTable table;

    public TableGUI(JTable table) {
        this.table = table;
    }

    public String[][] getContent() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[][] tl = new String[model.getRowCount()][model.getColumnCount()];
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                tl[i][j] = (String) model.getValueAt(i, j);
            }
        }

        return tl;
    }

    public void setContent(String[][] content, String[] title) {
        Object[][] v = (Object[][]) content;
        Object[] b = title;
        DefaultTableModel model = new DefaultTableModel(v, b);
        table.setModel(model);
        
        table.getColumnModel().getColumn(0).setMinWidth(150);
        table.getColumnModel().getColumn(0).setMaxWidth(150);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setMaxWidth(700);
        table.getColumnModel().getColumn(1).setMaxWidth(700);
        table.getColumnModel().getColumn(1).setPreferredWidth(700);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    
    public void setContent(String[][] content, String[] title, String type) {
        Object[][] v = (Object[][]) content;
        Object[] b = title;
        DefaultTableModel model = new DefaultTableModel(v, b);
        table.setModel(model);
    }

    public String[] getRow(int index) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] tl = new String[model.getColumnCount()];
        for (int j = 0; j < model.getColumnCount(); j++) {
            tl[j] = (String) model.getValueAt(index, j);
        }

        return tl;
    }

    public void addRow(String[] row) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow((Object[]) row);
        table.setModel(model);
    }

    public void deleteRow(int index) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(index);
//        
//        Object[][] v = null;
//        String[] title = {"Author", "Content", "Type"};
//        Object[] b = (Object[])title;
//        DefaultTableModel model2 = new DefaultTableModel(v, b);       
        table.setModel(model);
    }

    public int getSelectedIndex() {
        return table.getSelectedRow();
    }

    public int[] getSelectedIndexs(int index) {
        return table.getSelectedRows();
    }

    public String[] getSelectedRow() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] tl = new String[model.getColumnCount()];
        for (int j = 0; j < model.getColumnCount(); j++) {
            tl[j] = (String) model.getValueAt(getSelectedIndex(), j);
        }

        return tl;
    }

    public void clear() {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        int rowCount = model.getRowCount();
//        for (int i = 0; i < rowCount; i++) {
//            model.removeRow(i);
//        }
        
        Object[][] v = null;
        String[] title = {"Author", "Content", "Type"};
        Object[] b = (Object[])title;
        DefaultTableModel model2 = new DefaultTableModel(v, b);       
        table.setModel(model2);
        
        table.getColumnModel().getColumn(0).setMinWidth(150);
        table.getColumnModel().getColumn(0).setMaxWidth(150);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setMaxWidth(700);
        table.getColumnModel().getColumn(1).setMaxWidth(700);
        table.getColumnModel().getColumn(1).setPreferredWidth(700);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public int size() {
        return table.getRowCount();
    }

    public boolean isEmpty() {
        return table.getRowCount() == 0;
    }

    public String[] prepareTableTitle(List<String> title) {
        String[] b = new String[title.size()];
        b[0] = "Etkinlik Adı";
        b[1] = "Etkinlik Türü";
        b[2] = "Etkinlik Tarihi";

        return b;
    }

    public String[][] prepareTableContent(List<List<String>> content) {
        if(content == null){
            return null;
        }
        String[][] sonuc = new String[content.size()][];       

        for(int i=0; i<content.size(); i++){
            for(int j=0; j<content.get(i).size(); j++){
                sonuc[i][j] = content.get(i).get(j);
            }
        }

        return sonuc;
    }

    public void enable(boolean newEnable) {
        table.setEnabled(newEnable);
    }

    public boolean isEnable() {
        return table.isEnabled();
    }

    public void print(String title) {
        MessageFormat header = new MessageFormat(title);
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try{
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Yazdırılamadı", " ", JOptionPane.ERROR_MESSAGE);
        }
    }

}
