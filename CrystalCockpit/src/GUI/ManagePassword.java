/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Nan
 * @Write Program by Nan and Andre
 * 
 * Manage Password Description
 * ===========================
 * This function allow user to change own password.
 * This function checking
 * -“Enter Old Password” is right or not. If not show dialog box to user interface.
 * -“Enter New Password” and “Re-Enter Password” are same or not. I not same show dialog box to user make sure let them to key in same password for both. 
 * -Show new password level that is low or high
 * 
 * How Function work
 * =================
 * When Frame open, load all data from Database.
 *
 * When user click on "OK", system start to run script. If script no error proceed
 * and if script is error show error message on user interface.
 * 
 */
public class ManagePassword extends javax.swing.JPanel {

    /**
     * Creates new form ManagePassword
     */
    public ManagePassword() {
        initComponents();
    }
    
    public Controller thisController = new Controller();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        newPass1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        newPass2 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        oldPass = new javax.swing.JPasswordField();
        UIManager.put("ProgressBar.selectionBackground",Color.BLACK);
        UIManager.put("ProgressBar.selectionForeground",Color.BLACK);
        jProgressBar1 = new javax.swing.JProgressBar();
        cancel = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
        });

        jLabel1.setText("Enter New Password ");

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        ok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                okKeyPressed(evt);
            }
        });

        newPass1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                newPass1CaretUpdate(evt);
            }
        });

        jLabel2.setText("Re-Enter Password");

        jLabel3.setText("Enter Old Password");

        jProgressBar1.setMaximum(4);
        jProgressBar1.setToolTipText("");
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ok))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newPass1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(newPass2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(oldPass))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(oldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(newPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok)
                    .addComponent(cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        
        String message ="New password is weak. Do you want to change new password?";
        if(jProgressBar1.getString()=="Strong"){
            message = "Do you want to change new password?";
        }else if(jProgressBar1.getString().length()!= 0){
            message ="New Password is "+jProgressBar1.getString()
                    +". Do you want to change new Password?";
        }
    
        int reply = JOptionPane.showConfirmDialog(null, message, 
                "Click Yes or No", JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION){    
            if(newPass1.getText().equals(newPass2.getText()) && 
                    newPass1.getText()!="" &&
                    oldPass.getText().equals(thisController.pass)){
                actions();
                oldPass.setText("");
                newPass1.setText("");
                newPass2.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Incorrect password! Try it again.",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_okActionPerformed

    private void okKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ok.doClick();
        }
    }//GEN-LAST:event_okKeyPressed

    private void newPass1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_newPass1CaretUpdate
        String pw = newPass1.getText().toString();
        int value = checkPasswordStrength(pw);
        jProgressBar1.setValue(value);
        switch (value) {
            case 0: jProgressBar1.setString("");
                break;
            case 1: jProgressBar1.setString("Very Weak");
                break;
            case 2: jProgressBar1.setString("Weak");
                break;
            case 3: jProgressBar1.setString("Getting There");
                break;
            case 4: jProgressBar1.setString("Strong");
                break;
        }
    }//GEN-LAST:event_newPass1CaretUpdate

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        clean();
    }//GEN-LAST:event_cancelActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        clean();
    }//GEN-LAST:event_formAncestorAdded

    private void cancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cancel.doClick();
        }
    }//GEN-LAST:event_cancelKeyPressed
    
    private void actions(){
        //check connection and script is correct or not
        Boolean check = thisController.connectiontoDB("ManagePass");
        if(check == true){
            thisController.pass = newPass1.getText();
            JOptionPane.showMessageDialog(this, "New Password is changed.");
        }else{
            JOptionPane.showMessageDialog(this, thisController.errorMsg,
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int checkPasswordStrength(String password) {
        Color[] PB_COLORS = {Color.red, Color.red, Color.yellow, Color.yellow, Color.green};
        int strength = 0;
        
        String[] partialRegexChecks = {".*[a-z].*", // lower
            ".*[A-Z].*", // upper
            ".*[\\d].*", // digits
            ".*[^A-Za-z0-9].*" // symbols
        };

        if (password.matches(partialRegexChecks[0])) {
            strength++;
        }
        if (password.matches(partialRegexChecks[1])) {
            strength++;
        }
        if (password.matches(partialRegexChecks[2])) {
            strength++;
        }
        if (password.matches(partialRegexChecks[3])) {
            strength++;
        }
        if(strength == 4) strength = 3;
        if(password.length() >= 8)
            strength++;
        
        jProgressBar1.setForeground(PB_COLORS[strength]);
        return strength;
    }   
    
    private void clean(){
        oldPass.setText("");
        newPass1.setText("");
        newPass2.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    public static javax.swing.JPasswordField newPass1;
    private javax.swing.JPasswordField newPass2;
    private javax.swing.JButton ok;
    private javax.swing.JPasswordField oldPass;
    // End of variables declaration//GEN-END:variables
}