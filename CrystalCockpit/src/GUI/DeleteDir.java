/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Nan
 * @Write Program by Nan and Andre
 * 
 * Delete Directory
 * ================
 * This function allow user to delete directory from the current database.
 * This function checking 
 *  -Make sure user fill up all necessary information before process to 
 *  execute script. If information is not enough to execute script show 
 *  dialog box to user interface let user to fill up necessary information.
 * Allow user to see script by pressing “Show Script” and also let user to 
 * change script by click on “Edit Script”.
 * At the same time, allow user to save current script into drive/temp drive. 
 * So that user can take that script to anywhere.
 * 
 * How Function work
 * =================
 * When Frame open, load all data from Database.
 * 
 * When user click on "Show Script" set the choose=2 and call actions() to
 * connect Controller's functions to execute statement.
 * 
 * When user click on "Edit Script" text area will enabled and allow user to
 * change current script. Than set choice=3 and call actions() to connect
 * Controller's functions to execute statement.
 * 
 * When user click on "Save Script", system show dialog box and allow user to
 * choose file to save script. And get directory from user choose one and set
 * into writeScrpitForSave(directory,script) to write the script into the file.
 * 
 * When user click on "OK", system start to run script. If script no error proceed
 * and if script is error show error message on user interface.
 * 
 * When user click "Cancel", system clean the GUI.
 * 
 * When user click "re-flash icon 'image'", system will load existing data on
 * pane.
 * 
 */
public class DeleteDir extends javax.swing.JPanel {

    /**
     * Creates new form DeleteDir
     */
    public DeleteDir() {
        initComponents();
        
        scriptText.setDisabledTextColor(Color.BLACK);
    }
    public Controller thisController = new Controller();
    public int choice = 0 ;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        _dirList = new javax.swing.JComboBox();
        update = new javax.swing.JButton();
        showScript = new javax.swing.JButton();
        editScript = new javax.swing.JButton();
        saveScript = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        scriptText = new javax.swing.JTextArea();
        cancel = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setText("Directory Name:");

        _dirList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select One--" }));

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

        editScript.setText("Edit Script");
        editScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editScriptActionPerformed(evt);
            }
        });
        editScript.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editScriptKeyPressed(evt);
            }
        });

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

        scriptText.setColumns(20);
        scriptText.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scriptText.setRows(5);
        scriptText.setEnabled(false);
        jScrollPane1.setViewportView(scriptText);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveScript, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editScript, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showScript, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_dirList, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(_dirList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(showScript)
                        .addGap(18, 18, 18)
                        .addComponent(editScript)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveScript))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancel)
                            .addComponent(delete))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        retrieveDataFromDB();
    }//GEN-LAST:event_updateActionPerformed

    private void updateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            update.doClick();
        }
    }//GEN-LAST:event_updateKeyPressed

    private void showScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScriptActionPerformed
        saveScript.setEnabled(true);
        choice = 2;
        actions();
    }//GEN-LAST:event_showScriptActionPerformed

    private void showScriptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showScriptKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            showScript.doClick();
        }
    }//GEN-LAST:event_showScriptKeyPressed

    private void editScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editScriptActionPerformed
        choice = 3;//set choice that user click on edit script
        _dirList.setEnabled(false);
        showScript.setEnabled(false);
        scriptText.setEnabled(true);
        saveScript.setEnabled(true);
    }//GEN-LAST:event_editScriptActionPerformed

    private void editScriptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editScriptKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            editScript.doClick();
        }
    }//GEN-LAST:event_editScriptKeyPressed

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

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        clean();
    }//GEN-LAST:event_cancelActionPerformed

    private void cancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cancel.doClick();
        }
    }//GEN-LAST:event_cancelKeyPressed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you would like to Delete "
            +(String) _dirList.getSelectedItem(),
            "Click Yes or No", JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION){
            delete.setEnabled(false);
            if(choice == 3){//user click on edit script
                //set script that user make changes
                thisController.script = scriptText.getText();
                //execte the script
                Boolean check = thisController.connectiontoDB("script");
                if(check == true){//script is successful

                    JOptionPane.showMessageDialog(this, "Directory is Deleted.");
                    thisController.history(thisController.script);
                    retrieveDataFromDB();
                    clean();
                }else{//script is fail
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                    scriptText.setEnabled(true);
                    editScript.setEnabled(true);
                    cancel.setEnabled(true);
                    delete.setEnabled(true);
                }
            }else{
                choice = 1;//user didn't click on edit script
                actions();
            }
            retrieveDataFromDB();
        }else{
            clean();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void deleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            delete.doClick();
        }
    }//GEN-LAST:event_deleteKeyPressed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        retrieveDataFromDB();
    }//GEN-LAST:event_formAncestorAdded

      private void retrieveDataFromDB(){

        //get the list of tablespaces
        thisController.connectiontoDB("getDir");
  
        //set the list of tablespaces into array
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.addAll(thisController.arrList);
        
        //remove existing data
        _dirList.removeAllItems();
        
        //added tablespaces list from dtabase to gui design
        _dirList.addItem("--Please Select One--");
        for(int i = 0; i<arrList.size();i++){
            System.out.println(arrList.get(i));
            _dirList.addItem(arrList.get(i));
        }
    }
    
    private void actions(){
        if(choice == 1){//use didn't click on edit script

            Boolean check = thisController.connectiontoDB("deleteDir");  
            if(check == true){
                
                JOptionPane.showMessageDialog(this, "Directory is deleted.");
                thisController.history(thisController.deleteDir());
                retrieveDataFromDB();
                clean();           
            }else{
                JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        }else if (choice == 2){//user click on show script
            scriptText.setText(thisController.deleteDir());
        }      
    }
    
    private void clean(){//reflahs the GUI
        _dirList.setEnabled(true);
        showScript.setEnabled(true);
        editScript.setEnabled(true);
        delete.setEnabled(true);
        scriptText.setText("");
        scriptText.setEnabled(false);
        _dirList.setSelectedIndex(0);
        saveScript.setEnabled(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox _dirList;
    private javax.swing.JButton cancel;
    private javax.swing.JButton delete;
    private javax.swing.JButton editScript;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveScript;
    private javax.swing.JTextArea scriptText;
    private javax.swing.JButton showScript;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
