/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import static Controller.Controller.connection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Ben
 */
public class DeleteView extends javax.swing.JPanel {

    /**
     * Creates new form CreateTable
     */
    public Controller thisController = new Controller();
    static int i = 0;
    boolean checkEdit = false;
    public DeleteView() {
        if(i==1){
            initComponents();
            scriptText.setEditable(false);
            saveScript.setEnabled(false);
            
            scriptText.setDisabledTextColor(Color.BLACK);
        }
    }
    //Read the list of views from database
    private void readViewList(){
        AutoCompleteDecorator.decorate(viewList);
        View_List.clear();
        try {
            thisController.connectiontoDB("openConn");
            //all_views ARE THE LIST OF TABLES ARE ACCESIBLE TO THE CURRENT USRER
            String script = "SELECT VIEW_NAME FROM USER_VIEWS";
            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            while(rsQuery.next()){
                   View_List.add(rsQuery.getString(1));   
            } 
        } catch (SQLException ex) 
        {      
           JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        viewList.removeAllItems();
        viewList.addItem("--Please Select One--");
        for(int i=0;i<View_List.size();i++)
        {
            viewList.addItem(View_List.get(i));
        }
        try {
          connection.close();
        } catch (SQLException ex1) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private ArrayList<String> View_List = new ArrayList<String>();
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        viewList = new javax.swing.JComboBox();
        update = new javax.swing.JButton();
        showScript = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        scriptText = new javax.swing.JTextArea();
        saveScript = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        delete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deleteKeyPressed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        cancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelKeyPressed(evt);
            }
        });

        jLabel2.setText("Select the view you want to delete");

        viewList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select One--" }));

        update.setIcon(thisController.refreshIcon(15));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updateKeyPressed(evt);
            }
        });

        showScript.setText("Show Script");
        showScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showScriptActionPerformed(evt);
            }
        });
        showScript.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                showScriptKeyPressed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        edit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editKeyPressed(evt);
            }
        });

        scriptText.setColumns(20);
        scriptText.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scriptText.setRows(5);
        jScrollPane1.setViewportView(scriptText);

        saveScript.setText("Save Script");
        saveScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveScriptActionPerformed(evt);
            }
        });
        saveScript.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveScriptKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(viewList, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(edit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(showScript, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addComponent(saveScript, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(update)
                                .addGap(18, 18, 18)
                                .addComponent(cancel)
                                .addGap(18, 18, 18)
                                .addComponent(delete)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(viewList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showScript)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveScript))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cancel)
                                .addComponent(delete))
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        
        if(checkEdit==false){

            int checkSure = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete the view?", "Notice", JOptionPane.YES_NO_OPTION);
            if(checkSure==0){ 

                boolean k = true;
                try {
                    thisController.connectiontoDB("openConn");
                    String drop_Item = null;
                    drop_Item = (String) viewList.getSelectedItem();  
                    String script = "DROP VIEW " + drop_Item;
                    PreparedStatement st = connection.prepareStatement(script);
                    st.executeUpdate();
                    thisController.history(script);
                    
               }
               catch (SQLException ex)
               {
                   k= false;
                    JOptionPane.showMessageDialog(this,ex.getMessage()+ "Errror");
               }
                if(k==true)
                {
                    JOptionPane.showMessageDialog(this,"View deleted");
                }
                try {
                    connection.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        else
        {
            int checkSure = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete the table?", "Notice", JOptionPane.YES_NO_OPTION);
            if(checkSure==0){ 

                boolean k = true;
                try {
                    
                    thisController.connectiontoDB("openConn");
                    String script = scriptText.getText();
                    PreparedStatement st = connection.prepareStatement(script);
                    st.executeUpdate();
                    thisController.history(script);
                    
               }
               catch (SQLException ex)
               {
                   k= false;
                    JOptionPane.showMessageDialog(this,ex.getMessage());
               }
                if(k==true)
                {
                    JOptionPane.showMessageDialog(this,"View deleted");
                }
                try {
                    connection.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        scriptText.setText("");
        update.doClick();
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        //AutoCompleteDecorator.decorate(jComboBox1);
        //jComboBox1.enable();
        View_List.clear();
        try {
            thisController.connectiontoDB("openConn");
            //all_views ARE THE LIST OF TABLES ARE ACCESIBLE TO THE CURRENT USRER
            String script = "SELECT VIEW_NAME FROM USER_VIEWS";
            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            while(rsQuery.next()){
                   View_List.add(rsQuery.getString(1));   
            } 
        } catch (SQLException ex) 
        {      
           JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        viewList.removeAllItems();
        viewList.addItem("--Please Select One--");
        for(int i=0;i<View_List.size();i++)
        {
            viewList.addItem(View_List.get(i));
        }
        try {
            connection.close();
        } catch (SQLException ex1) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void showScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScriptActionPerformed
        

        String drop_Item = null;
        drop_Item = (String) viewList.getSelectedItem();  
        String script = "DROP VIEW " + drop_Item;
        scriptText.setText(script);
        saveScript.setEnabled(true);
        
    }//GEN-LAST:event_showScriptActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        
        scriptText.setEditable(true);
        checkEdit = true;
        saveScript.setEnabled(true);
    }//GEN-LAST:event_editActionPerformed

    private void updateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            update.doClick();
        }
    }//GEN-LAST:event_updateKeyPressed

    private void deleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            delete.doClick();
        }
    }//GEN-LAST:event_deleteKeyPressed

    private void cancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cancel.doClick();
        }
    }//GEN-LAST:event_cancelKeyPressed

    private void showScriptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showScriptKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            showScript.doClick();
        }
    }//GEN-LAST:event_showScriptKeyPressed

    private void editKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edit.doClick();
        }
    }//GEN-LAST:event_editKeyPressed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        scriptText.setText("");
        update.doClick();
        saveScript.setEnabled(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void saveScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveScriptActionPerformed

        int val = 0;

        //set button name for fileChooser
        UIManager.put("FileChooser.openDialogTitleText", "Load Script File");
        UIManager.put("FileChooser.openButtonText", "Save Script");

        //Browse file from drive
        JFileChooser fileChooser = new JFileChooser();

        try {
            val = fileChooser.showOpenDialog(null);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error opening the file dialogue",
                null, JOptionPane.ERROR_MESSAGE);
        }

        //if file is approve to open start to save the script to that file
        if (val == JFileChooser.APPROVE_OPTION) {
            String saveScriptPath = fileChooser.getSelectedFile().getAbsolutePath();
            if(saveScriptPath.endsWith(".sql")){
                thisController.writeScrpitForSave(saveScriptPath,scriptText.getText());
            }else{
                saveScriptPath = saveScriptPath+".sql";
                thisController.writeScrpitForSave(saveScriptPath,scriptText.getText());
            }
            JOptionPane.showMessageDialog(null, "Script is Saved.");
        }
    }//GEN-LAST:event_saveScriptActionPerformed

    private void saveScriptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveScriptKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            saveScript.doClick();
        }
    }//GEN-LAST:event_saveScriptKeyPressed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        readViewList();
    }//GEN-LAST:event_formAncestorAdded

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveScript;
    private javax.swing.JTextArea scriptText;
    private javax.swing.JButton showScript;
    private javax.swing.JButton update;
    private javax.swing.JComboBox viewList;
    // End of variables declaration//GEN-END:variables
}
