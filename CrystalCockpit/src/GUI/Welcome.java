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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nan and Ben
 */
public class Welcome extends javax.swing.JPanel {

    //For fitst runner error
    static int i=0;

    //For the history table
    Object[][] data = null;
    
    //For connection
    public Controller thisController = new Controller();
    

    /**
     * Creates new form Welcome
     */
    public Welcome() {
        if(i==1){
    
            initComponents();
            CheckDataBaseExist();
            initialHistoryTable();
            textScript.setDisabledTextColor(Color.BLACK);
        }
        
    }

     //Transfer data from table to here
    private void initialHistoryTable()
    {
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        
        thisController.connectiontoDB("openConn");
        String script = "";
        try {
        
            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            while(rsQuery.next())
            {
                int id = rsQuery.getInt("ID");
                String sc = rsQuery.getString("SCRIPT");
                
                model.addRow(new Object[]{ id, sc   });
            }

        } catch (SQLException ex) {
        }
        try {
              connection.close();
        } catch (SQLException ex1) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }        
        
    }
     
    
    
    //Check if database for history does not exist it will produce one with sequence
    private void CheckDataBaseExist()
    {
        if(thisController.name.equals("system")){
            
            //get the list of table
            thisController.connectiontoDB("getTab");

            //set the list of tables into array
            ArrayList<String> arrList = new ArrayList<String>();
            arrList.addAll(thisController.arrList);

            boolean checkTable = false;
            for(int i = 0; i<arrList.size();i++){
                if(arrList.get(i).equals("HISTORY")){
                    checkTable = true;
                }
            }
            if(checkTable == false){
                thisController.connectiontoDB("openConn");
                String createTable= "CREATE TABLE HISTORY "+
                        "( SCRIPT VARCHAR2(1000) NOT NULL, "+
                        "TIME VARCHAR2(20) NOT NULL, "+
                        "PCNUMBER VARCHAR2(30) NOT NULL, "+ 
                        "USERNAME VARCHAR2(30) NOT NULL )";
                
                try {
                    Statement stmQuery = connection.createStatement();
                    stmQuery.executeQuery (createTable);

                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                      connection.close();
                } catch (SQLException ex1) {
                   Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
            }
 
                //get the list of Users
                thisController.connectiontoDB("getOpenUser");
  
                //set the list of users into array
                ArrayList<String> _arrList = new ArrayList<String>();
                _arrList.addAll(thisController.arrList);
        
                
                //added users list from dtabase to gui design
                for(int i = 0; i<_arrList.size();i++){
                    thisController.connectiontoDB("openConn");
                    String script = "GRANT SELECT ANY TABLE,INSERT ANY TABLE"
                        + " TO "+_arrList.get(i);                
                    try{
                        Statement stmQuery = connection.createStatement();
                        stmQuery.executeQuery(script);
                    }catch(SQLException ex){
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try{
                        connection.close();
                    }catch(SQLException ex1){
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textScript = new javax.swing.JTextArea();
        runScript = new javax.swing.JButton();
        reflash = new javax.swing.JButton();
        saveScript = new javax.swing.JButton();
        loadScript = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(750, 527));
        setPreferredSize(new java.awt.Dimension(750, 527));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Welcome to Crystal Cockpit");
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 58));
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 58));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SCRIPT", "TIME", "PC NUMBER", "USER NAME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        textScript.setColumns(20);
        textScript.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textScript.setRows(5);
        jScrollPane2.setViewportView(textScript);

        runScript.setText("Run");
        runScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runScriptActionPerformed(evt);
            }
        });
        runScript.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                runScriptKeyPressed(evt);
            }
        });

        reflash.setText("Refresh");
        reflash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reflashActionPerformed(evt);
            }
        });
        reflash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reflashKeyPressed(evt);
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

        loadScript.setText("Load Script");
        loadScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadScriptActionPerformed(evt);
            }
        });
        loadScript.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loadScriptKeyPressed(evt);
            }
        });

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        clear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clearKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(reflash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(runScript, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveScript, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loadScript, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveScript)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadScript)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runScript))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reflash))
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reflashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflashActionPerformed
   
        thisController.connectiontoDB("openConn");
        
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        //int count = model.getRowCount();
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        String script = " SELECT SCRIPT, TIME, PCNUMBER, USERNAME FROM "
                + "SYSTEM.HISTORY where USERNAME = '"+Controller.name+"' ";

        try {
            
            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            int i = 1;
            while(rsQuery.next())
            { 
                
                String sc = rsQuery.getString(1);
                String time = rsQuery.getString(2);
                String pc = rsQuery.getString(3);
                String un = rsQuery.getString(4); 
                            
                model.addRow(new Object[]{ i , sc, time, pc, un});
                i++;
         
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
              connection.close();
        } catch (SQLException ex1) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }//GEN-LAST:event_reflashActionPerformed

    private void saveScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveScriptActionPerformed

         int val = 0;
         UIManager.put("FileChooser.openDialogTitleText", "Save Script File");
         UIManager.put("FileChooser.openButtonText", "Save Script");
        //Browse file from drive
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("SQL script file (*.sql)", "sql");
        fileChooser.setFileFilter(filter);
        try {
        val = fileChooser.showOpenDialog(null);
        } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(null, "Error opening the file dialogue",
        null, JOptionPane.ERROR_MESSAGE);
        }

        if (val == JFileChooser.APPROVE_OPTION) {
        String saveScriptPath = fileChooser.getSelectedFile().getAbsolutePath();
        if(saveScriptPath.endsWith(".sql")){
        thisController.writeScrpitForSave(saveScriptPath,textScript.getText());
        }else{
        saveScriptPath = saveScriptPath+".sql";
        thisController.writeScrpitForSave(saveScriptPath,textScript.getText());
        }
        JOptionPane.showMessageDialog(null, "Script is Saved.");
        }    
    }//GEN-LAST:event_saveScriptActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
  
        int  selected_row = table.getSelectedRow();
        if(selected_row == -1)
        {
            //do nothing
        }
        else
        {
            textScript.setText(table.getValueAt(selected_row, 1).toString());
        }
    }//GEN-LAST:event_tableMousePressed

    private void runScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runScriptActionPerformed
        
        thisController.script = textScript.getText();
        boolean check = thisController.connectiontoDB("script");
        if(check == true){
            JOptionPane.showMessageDialog(null, "Script is executed.");
        }   else{
            JOptionPane.showMessageDialog(null, thisController.errorMsg,
                null, JOptionPane.ERROR_MESSAGE);
        }     
        
    }//GEN-LAST:event_runScriptActionPerformed

    private void loadScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadScriptActionPerformed
        int val = 0;

        //Browse file from drive
        UIManager.put("FileChooser.openDialogTitleText", "Load Script File");
         UIManager.put("FileChooser.openButtonText", "Load Script");
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("SQL script file (*.sql)", "sql");
        fileChooser.setFileFilter(filter);
        try {
        val = fileChooser.showOpenDialog(null);
        } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(null, "Error opening the file dialogue",
        null, JOptionPane.ERROR_MESSAGE);
        }

        if (val == JFileChooser.APPROVE_OPTION) {
        String path = fileChooser.getSelectedFile().getAbsolutePath();
        String content= thisController.readFromFile(path);
        textScript.setText(content);

        }
    }//GEN-LAST:event_loadScriptActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        reflash.doClick();
    }//GEN-LAST:event_formAncestorAdded

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        textScript.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void clearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clearKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            clear.doClick();
        }
    }//GEN-LAST:event_clearKeyPressed

    private void saveScriptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveScriptKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            saveScript.doClick();
        }
    }//GEN-LAST:event_saveScriptKeyPressed

    private void loadScriptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loadScriptKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            loadScript.doClick();
        }
    }//GEN-LAST:event_loadScriptKeyPressed

    private void runScriptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_runScriptKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            runScript.doClick();
        }
    }//GEN-LAST:event_runScriptKeyPressed

    private void reflashKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reflashKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            reflash.doClick();
        }
    }//GEN-LAST:event_reflashKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadScript;
    private javax.swing.JButton reflash;
    private javax.swing.JButton runScript;
    private javax.swing.JButton saveScript;
    public static javax.swing.JTable table;
    private javax.swing.JTextArea textScript;
    // End of variables declaration//GEN-END:variables
}
