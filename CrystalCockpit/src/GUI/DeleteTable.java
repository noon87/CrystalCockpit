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
/**
 *
 * @author Ben
 */
public class DeleteTable extends javax.swing.JPanel {
private ArrayList<String> Table_List = new ArrayList<String>();
    /**
     * Creates new form CreateTable
     */
    boolean checkEdit = false;
    static int i=0;
    public Controller thisController = new Controller();
    public DeleteTable() {
        
        if(i==1){
            initComponents();
            scriptText.setEditable(false);
            saveScript.setEnabled(false);
            scriptText.setDisabledTextColor(Color.BLACK);
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tableList = new javax.swing.JComboBox();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        scriptText = new javax.swing.JTextArea();
        showScript = new javax.swing.JButton();
        edit = new javax.swing.JButton();
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

        jLabel5.setText("Select the view you want to delete");

        tableList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select One--" }));

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

        scriptText.setColumns(20);
        scriptText.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scriptText.setRows(5);
        jScrollPane1.setViewportView(scriptText);

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
        edit.setMaximumSize(new java.awt.Dimension(89, 23));
        edit.setMinimumSize(new java.awt.Dimension(89, 23));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(saveScript, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(showScript, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tableList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(update)
                        .addGap(18, 18, 18)
                        .addComponent(cancel)
                        .addGap(18, 18, 18)
                        .addComponent(delete)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tableList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showScript)
                        .addGap(18, 18, 18)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveScript)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete)
                        .addComponent(cancel))
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(checkEdit==false){
            int checkSure = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete the table?", "Notice", JOptionPane.YES_NO_OPTION);
            if(checkSure==0){ 
                boolean k = true;
                try {
                    thisController.connectiontoDB("openConn");
                    String drop_Item = null;
                    drop_Item = (String) tableList.getSelectedItem();
                    String script = "DROP TABLE " + drop_Item;
                    PreparedStatement st = connection.prepareStatement(script);
                    st.executeUpdate();
                    thisController.history(script);
                    
                }catch (SQLException ex) 
                {
                    k=false;
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                } 

                tableList.removeAllItems();
                tableList.addItem("--Please Select One--");
                for(int i=0;i<Table_List.size();i++)
                {
                    if(Table_List.get(i).toUpperCase().equals("HISTORY")){}else{
                    tableList.addItem(Table_List.get(i));
                    }
                }


                if(k==true)
                {
                    JOptionPane.showMessageDialog(this,"TABLE deleted");
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
                "Are you sure you want to delete the table?", "Notice", 
                JOptionPane.YES_NO_OPTION);
                if(checkSure==0){ 
                
                boolean k = true;
                try {
                    thisController.connectiontoDB("openConn");
                    String drop_Item = null;
                    drop_Item = (String) tableList.getSelectedItem();
                    String script = scriptText.getText();
                    PreparedStatement st = connection.prepareStatement(script);
                    st.executeUpdate();
                    thisController.history(script);
                    
                }catch (SQLException ex) 
                {
                    k=false;
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 
                            JOptionPane.ERROR_MESSAGE);
                } 

                tableList.removeAllItems();
                tableList.addItem("--Please Select One--");
                for(int i=0;i<Table_List.size();i++)
                {
                    if(Table_List.get(i).toUpperCase().equals("HISTORY")){}else{
                    tableList.addItem(Table_List.get(i));
                    }
                }


                if(k==true)
                {
                    JOptionPane.showMessageDialog(this,"TABLE deleted");
                }
                try {
                    connection.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
                }
                }
            }
            update.doClick();
            scriptText.setText("");
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        Table_List.clear();
        try {
            thisController.connectiontoDB("openConn");
            //all_views ARE THE LIST OF TABLES ARE ACCESIBLE TO THE CURRENT USRER
            String script = "SELECT TABLE_NAME FROM USER_TABLES";
            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            while(rsQuery.next()){
                Table_List.add(rsQuery.getString(1));
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        tableList.removeAllItems();
        tableList.addItem("--Please Select One--");
        for(int i=0;i<Table_List.size();i++)
        {
            if(Table_List.get(i).toUpperCase().equals("HISTORY")){}else{
            tableList.addItem(Table_List.get(i));
            }
        }
        
        try {
            connection.close();
        } catch (SQLException ex1) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void showScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScriptActionPerformed
        


        String drop_Item = null;
        drop_Item = (String) tableList.getSelectedItem();
        String script = "DROP TABLE " + drop_Item;

        scriptText.setText(script);
        
        saveScript.setEnabled(true);
        
    }//GEN-LAST:event_showScriptActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        checkEdit = true;
        scriptText.setEditable(true);
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

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
                Table_List.clear();
        try {
            thisController.connectiontoDB("openConn");
            //all_views ARE THE LIST OF TABLES ARE ACCESIBLE TO THE CURRENT USRER
            String script = "SELECT TABLE_NAME FROM USER_TABLES";
            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            while(rsQuery.next()){
                   Table_List.add(rsQuery.getString(1));   
            } 
        } catch (SQLException ex) 
        {      
           JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        tableList.removeAllItems();
        tableList.addItem("--Please Select One--");
        for(int i=0;i<Table_List.size();i++)
        {
            if(Table_List.get(i).toUpperCase().equals("HISTORY")){}else{
            tableList.addItem(Table_List.get(i));
            }
        }
        
        try {
            connection.close();
        } catch (SQLException ex1) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }//GEN-LAST:event_formAncestorAdded

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
        scriptText.setText("");
        saveScript.setEnabled(false);
        tableList.setSelectedIndex(0);
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
  
        //Return name of the database by Ben
    public  String getDBName(){
        
        
        thisController.connectiontoDB("openConn");
        try {
              connection.close();
        } catch (SQLException ex1) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        
        String dbNameTmp = null;
        String script = "SELECT sys_context('userenv','instance_name') from dual"; 
        try {
            //thisController.connectCmd("openConn");

            Statement stmQuery = connection.createStatement();        
            ResultSet rsQuery = stmQuery.executeQuery (script);
            rsQuery.next();
            dbNameTmp = rsQuery.getString(1);
            
            //connection.close();
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "\n Problem with database name "+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
              connection.close();
        } catch (SQLException ex1) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return dbNameTmp;
    }
    
    //Return name of the all the tables and views user can access by Ben
        public  ArrayList<String> getTableNames(){
            ArrayList<String> Table_List = new ArrayList<String>();
            thisController.connectiontoDB("openConn");
       
        try {
            
            String script = "SELECT VIEW_NAME from USER_VIEWS";
            String script2 = "SELECT table_name from user_tables";

            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            
            while(rsQuery.next())
            {
                Table_List.add( rsQuery.getString(1));;
            }  
            
            Statement stmQuery2 = connection.createStatement();
            ResultSet rsQuery2 = stmQuery2.executeQuery (script2);
            while(rsQuery2.next())
            {
                Table_List.add( rsQuery2.getString(1));;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
              connection.close();
        } catch (SQLException ex1) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return Table_List;
    }

        //Return name of all the columns in the table in arguments by Ben
        public  String[] getTableColumnNames(String tableName){
                
            thisController.connectiontoDB("openConn");
 
           int sizeTable;
           String[] Table_List = null;
           try {
            
            String script = "select count(*)  from all_tab_cols  where table_name = '"+ tableName +"'";            
            String script2 = ""
                    + "SELECT COLUMN_NAME "
                    + " FROM ALL_TAB_COLS "
                    + " WHERE TABLE_NAME = '"+ tableName +"'"; 
                   
            
             Statement stmQuery = connection.createStatement();
             ResultSet rsQuery = stmQuery.executeQuery (script);
             rsQuery.next();
             sizeTable = rsQuery.getInt(1);

            int i=0;
            Table_List = new String[sizeTable];
            Statement stmQuery2 = connection.createStatement();
            ResultSet rsQuery2 = stmQuery2.executeQuery (script2);
            while(rsQuery2.next())
            {              
                Table_List[i] = rsQuery2.getString(1);
                i++;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
           
         
        try {
              connection.close();
        } catch (SQLException ex1) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
           
        return Table_List;
     }    

        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveScript;
    private javax.swing.JTextArea scriptText;
    private javax.swing.JButton showScript;
    private javax.swing.JComboBox tableList;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
