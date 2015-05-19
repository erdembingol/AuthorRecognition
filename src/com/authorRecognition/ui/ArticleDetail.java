package com.authorRecognition.ui;

import com.authorRecognition.db.DatabaseOperation;
import com.authorRecognition.zemberek.Article;
import com.authorRecognition.ui.swing.MessageBox;
import com.authorRecognition.ui.swing.TableGUI;
import com.authorRecognition.ui.swing.TextAreaGUI;
import com.authorRecognition.ui.swing.TextBoxGUI;
import com.authorRecognition.weka.ArticleProperty;
import com.authorRecognition.zemberek.ArticleOperation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erdem_000
 */
public class ArticleDetail extends javax.swing.JFrame {

    Article article = null;
    TableGUI sentenceStatisticGUI = null;
    TableGUI wordStatisticGUI = null;
    TableGUI markStatisticGUI = null;
    TableGUI otherStatisticGUI = null;
    TextAreaGUI contentGUI = null;
    TextAreaGUI articleDetailGUI = null;
    TextBoxGUI authorGUI = null;
    TextBoxGUI typeGUI = null;
    
    /**
     * Creates new form ArticleDetail
     */
    public ArticleDetail() {
        initComponents();
        
        sentenceStatisticGUI = new TableGUI(this.sentenceTable);
        wordStatisticGUI = new TableGUI(this.wordTable);
        markStatisticGUI = new TableGUI(this.markTable);
        otherStatisticGUI = new TableGUI(this.otherTable);
        contentGUI = new TextAreaGUI(this.contentTextArea);
        articleDetailGUI = new TextAreaGUI(this.articleDetailTextArea);
        authorGUI = new TextBoxGUI(this.authorTextField);
        typeGUI = new TextBoxGUI(this.typeTextField);      
    }
    
    public ArticleDetail(Article article) {
        initComponents();
        
        this.article = article;
        sentenceStatisticGUI = new TableGUI(this.sentenceTable);
        wordStatisticGUI = new TableGUI(this.wordTable);
        markStatisticGUI = new TableGUI(this.markTable);
        otherStatisticGUI = new TableGUI(this.otherTable);
        contentGUI = new TextAreaGUI(this.contentTextArea);
        articleDetailGUI = new TextAreaGUI(this.articleDetailTextArea);
        authorGUI = new TextBoxGUI(this.authorTextField);
        typeGUI = new TextBoxGUI(this.typeTextField);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        authorTextField = new javax.swing.JTextField();
        typeTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        sentenceTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        markTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        wordTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        otherTable = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        articleDetailTextArea = new javax.swing.JTextArea();
        listDetailButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Article Detail");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Author");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Type");

        authorTextField.setBackground(new java.awt.Color(240, 240, 240));
        authorTextField.setEnabled(false);

        typeTextField.setBackground(new java.awt.Color(240, 240, 240));
        typeTextField.setEnabled(false);

        contentTextArea.setEditable(false);
        contentTextArea.setColumns(20);
        contentTextArea.setRows(5);
        contentTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(contentTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        sentenceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        sentenceTable.setEnabled(false);
        jScrollPane2.setViewportView(sentenceTable);

        markTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        markTable.setEnabled(false);
        jScrollPane3.setViewportView(markTable);

        wordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        wordTable.setEnabled(false);
        jScrollPane4.setViewportView(wordTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Sentence Statistics");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Word Statistics");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Mark Statistics");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Other Statistics");

        otherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        otherTable.setEnabled(false);
        jScrollPane5.setViewportView(otherTable);

        articleDetailTextArea.setEditable(false);
        articleDetailTextArea.setColumns(20);
        articleDetailTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        articleDetailTextArea.setForeground(new java.awt.Color(102, 102, 102));
        articleDetailTextArea.setRows(5);
        articleDetailTextArea.setText("Please click 'List Detail' for show article sentences and words");
        jScrollPane13.setViewportView(articleDetailTextArea);

        listDetailButon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listDetailButon.setForeground(new java.awt.Color(0, 153, 153));
        listDetailButon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/authorRecognition/images/accept-icon.png"))); // NOI18N
        listDetailButon.setText("List Detail");
        listDetailButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listDetailButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane5)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(listDetailButon))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listDetailButon, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.authorGUI.setText(article.getAuthor());
        this.typeGUI.setText(article.getType().getName());
        this.contentGUI.setText(article.getContent());
        
        DatabaseOperation db = new DatabaseOperation();
        try {
            db.connect();
            ArticleProperty ap = db.getArticleProperty(this.article.getId());
            
            List<String> list = ap.getProperties();         
            List<String> sentenceTitleList = new ArrayList<>();
            List<String> wordTitleList = new ArrayList<>();
            List<String> markTitleList = new ArrayList<>();
            List<String> otherTitleList = new ArrayList<>();
            
            List<String> sentenceContentList = new ArrayList<>();
            List<String> wordContentList = new ArrayList<>();
            List<String> markContentList = new ArrayList<>();
            List<String> otherContentList = new ArrayList<>();
            
            for (int i = 0; i < list.size(); i++) {
                if(i < 3){
                    sentenceTitleList.add(list.get(i));
                    sentenceContentList.add(ap.getValue(i));
                }else if(i < 9){
                    wordTitleList.add(list.get(i));
                    wordContentList.add(ap.getValue(i));
                }else if(i < 19){
                    markTitleList.add(list.get(i));
                    markContentList.add(ap.getValue(i));
                }else{
                    otherTitleList.add(list.get(i));
                    otherContentList.add(ap.getValue(i));
                }
            }           
            
            TableGUI sentenceT = new TableGUI(this.sentenceTable);
            TableGUI wordT = new TableGUI(this.wordTable);
            TableGUI markT = new TableGUI(this.markTable);
            TableGUI otherT = new TableGUI(this.otherTable);
            
            String[] sentenceTitle = new String[sentenceTitleList.size()];
            for (int i = 0; i < sentenceTitleList.size(); i++) {
                sentenceTitle[i] = sentenceTitleList.get(i);
            }            
            String[][] sentenceContent = new String[1][sentenceContentList.size()];
            for (int i = 0; i < sentenceContentList.size(); i++) {
                sentenceContent[0][i] = sentenceContentList.get(i);
            }
            sentenceT.setContent(sentenceContent, sentenceTitle, "");
            
            String[] wordTitle = new String[wordTitleList.size()];
            for (int i = 0; i < wordTitleList.size(); i++) {
                wordTitle[i] = wordTitleList.get(i);
            }            
            String[][] wordContent = new String[1][wordContentList.size()];
            for (int i = 0; i < wordContentList.size(); i++) {
                wordContent[0][i] = wordContentList.get(i);
            }
            wordT.setContent(wordContent, wordTitle, "");
            
            String[] markTitle = new String[markTitleList.size()];
            for (int i = 0; i < markTitleList.size(); i++) {
                markTitle[i] = markTitleList.get(i);
            }           
            String[][] markContent = new String[1][markContentList.size()];
            for (int i = 0; i < markContentList.size(); i++) {
                markContent[0][i] = markContentList.get(i);
            }
            markT.setContent(markContent, markTitle, "");
            
            String[] otherTitle = new String[otherTitleList.size()];
            for (int i = 0; i < otherTitleList.size(); i++) {
                otherTitle[i] = otherTitleList.get(i);
            }      
            String[][] otherContent = new String[1][otherContentList.size()];
            for (int i = 0; i < otherContentList.size(); i++) {
                otherContent[0][i] = otherContentList.get(i);
            }
            otherT.setContent(otherContent, otherTitle, "");
            
            db.disconnect();
        } catch (Exception ex) {
            MessageBox.informationMessage("", "Article properties not found!!!");
        }
    }//GEN-LAST:event_formWindowOpened

    private void listDetailButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listDetailButonActionPerformed
        articleDetailGUI.setText("Article Properties is calculating, please wait...");
        
        List<String> list = null;
        ArticleOperation ao = new ArticleOperation(article);
        StringBuilder detail = new StringBuilder();
        detail.append("================================================= Sentences =============================================\n\n");
        list = ao.getSentences();
        for (int i = 0; i < list.size(); i++) {
            detail.append(list.get(i));
            detail.append('\n');
        }
        
        detail.append("\n\n\n=========================================== Words ===================================================\n\n");
        list = ao.getWords();
        for (int i = 0; i < list.size(); i++) {
            detail.append(list.get(i)).append(", ");
        }
        detail.append("\n");
              
        articleDetailGUI.setText(detail.toString());
    }//GEN-LAST:event_listDetailButonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArticleDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArticleDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArticleDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArticleDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArticleDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea articleDetailTextArea;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JTextArea contentTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton listDetailButon;
    private javax.swing.JTable markTable;
    private javax.swing.JTable otherTable;
    private javax.swing.JTable sentenceTable;
    private javax.swing.JTextField typeTextField;
    private javax.swing.JTable wordTable;
    // End of variables declaration//GEN-END:variables
}