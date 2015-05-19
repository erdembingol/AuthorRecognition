package com.authorRecognition.ui.swing;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class JavaGUI {
    
    private JTable table;
    private JList list;
    private JComboBox combobox;
    
    public JavaGUI(JTable table, JList list, JComboBox combobox){
        this.combobox = combobox;
        this.list = list;
        this.table = table;
    }
    
    /************************JTABLE***********************************/
    
    public void tableListele(String[][] veri, String[] baslik){
        Object[][] v = (Object[][])veri;
        Object[] b = baslik;
        TableModel model = new DefaultTableModel(v,b);                     
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
    
    public String[][] tableGetList(){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        String[][] tl = new String[model.getRowCount()][model.getColumnCount()];
        for(int i=0;i<model.getRowCount();i++){
            for(int j=0;j<model.getColumnCount();j++){
                tl[i][j] = (String)model.getValueAt(i, j);
            }
        }
        
        return tl;
    }
    
    public String[] tableGetRow(int index){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        String[] tl = new String[model.getColumnCount()];
        for(int j=0;j<model.getColumnCount();j++){
            tl[j] = (String)model.getValueAt(index, j);
        }
        
        return tl;
    }
    
    public void tableAddRow(String[] veri){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow((Object[])veri);
        table.setModel(model);
    }
    
    public void tableRemoveRow(int row){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.removeRow(row);
        table.setModel(model);
    }
    
    public void tableClear(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0;i<rowCount;i++) {
            model.removeRow(i);
        }
    }
    
    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch"})
    public void tablePrint(String baslik){
        MessageFormat header = new MessageFormat(baslik);
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try{
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Yazdırılamadı", " ", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /************************JCOMBOBOX*********************************/
    
    public void comboBoxListele(Set<String> veri){
        Iterator<String> it = veri.iterator();
        for(int i=0; it.hasNext(); i++)
            combobox.addItem(it.next());
    }
    
    public String[] comboBoxGetList(){
        String[] cl = new String[combobox.getModel().getSize()];
        for(int i=0; i<combobox.getModel().getSize(); i++)
            cl[i] = (String)combobox.getModel().getElementAt(i);
        
        return cl;
    }
    
    public String comboBoxGetRow(int index){
        String cl;
        cl = (String)combobox.getModel().getElementAt(index);
        
        return cl;
    }
    
    public void comboBoxAddRow(String veri){
        combobox.addItem(veri);
    }
    
    public void comboBoxRemoveRow(int index){
        combobox.remove(index);
    }
    
    public void comboBoxClear(){
        int itemCount = combobox.getItemCount();
        for(int i=0;i<itemCount;i++){
            combobox.removeItemAt(0);
        }
    }
    
    /************************JLIST*************************************/
    
    public void listBoxListele(Set<String> veri){
        DefaultListModel dlm1 = new DefaultListModel();
        Iterator<String> it = veri.iterator();
        for(int i=0; it.hasNext(); i++){
            dlm1.addElement(it.next());
        }
        list.setModel(dlm1);
    }
    
    public String[] listBoxGetList(){
        String[] ll = new String[list.getModel().getSize()];
        for(int i=0; i<list.getModel().getSize(); i++)
            ll[i] = (String)list.getModel().getElementAt(i);
        
        return ll;
    }
    
    public String listBoxGetRow(int index){
        String ll;
        ll = (String)list.getModel().getElementAt(index);
        
        return ll;
    }
    
    public void listBoxAddRow(String veri){
        DefaultListModel model = (DefaultListModel)list.getModel();
        model.addElement(veri);
        list.setModel(model);
    }
    
    public void listBoxRemoveRow(int index){
        DefaultListModel model = (DefaultListModel)list.getModel();
        model.remove(index);
        list.setModel(model);
    }    
    
    public void listBoxClear(){
        DefaultListModel model = (DefaultListModel)list.getModel();
        model.removeAllElements();
        list.setModel(model);
    }
    
    /************************JTEXTFIELD********************************/
    
    public void textFieldFill(List<String> list, List<JTextField> textfields){
        for(int i=0; i<list.size(); i++)
            textfields.get(i).setText(list.get(i));
    }
}
