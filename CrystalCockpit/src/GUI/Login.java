/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Andre
 */
@SuppressWarnings("serial")
public class Login extends javax.swing.JFrame {

    public Controller thisController = new Controller();
    public ArrayList<String> privsList=new ArrayList<String>();

    public Login() throws IOException {
        
        CreateTable.i = 1;
        CreatView.i = 1;
        DeleteMaterializeView.i = 1;
        DeleteTable.i = 1;
        DeleteView.i = 1;
        CreatMaterializeView.i=1;
        DeleteSequence.i =1;
        CreatSequence.i=1;
        Welcome.i=1;
        
        initComponents();          
    }    
    
    
    public Image Crystal() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/Crystal Cockpit.png"));
        Image img = icon.getImage() ;  
        return img;    
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
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dbName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        url = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crystal Cockpit");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(Crystal());
        setLocationByPlatform(true);

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenWelcome(evt);
            }
        });
        loginBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pressEnter(evt);
            }
        });

        jLabel3.setText("Database Name:");

        dbName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dbNameKeyPressed(evt);
            }
        });

        jLabel4.setText("host");

        url.setText("localhost");
        url.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyPressedAction(evt);
            }
        });

        jLabel5.setText("Port");

        port.setText("1521");
        port.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                portKeyPressed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Crystal Cockpit.png"))); // NOI18N
        jLabel6.setText("Crystal Cockpit");
        jLabel6.setToolTipText("");
        jLabel6.setIconTextGap(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(dbName, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(url, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(port, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(57, 57, 57))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(loginBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(dbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(loginBtn)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(717, 430));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void OpenWelcome(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenWelcome
        actions();
    }//GEN-LAST:event_OpenWelcome

    private void pressEnter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pressEnter
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            loginBtn.doClick();
        }
    }//GEN-LAST:event_pressEnter

    private void keyPressedAction(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPressedAction
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            loginBtn.doClick();
        }
    }//GEN-LAST:event_keyPressedAction

    private void portKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_portKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            loginBtn.doClick();
        }
    }//GEN-LAST:event_portKeyPressed

    private void dbNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbNameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            loginBtn.doClick();
        }
    }//GEN-LAST:event_dbNameKeyPressed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            loginBtn.doClick();
        }
    }//GEN-LAST:event_usernameKeyPressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            loginBtn.doClick();
        }
    }//GEN-LAST:event_passwordKeyPressed

    private void actions(){
        thisController.setLoginInfo();
        //check successfull login or not
        Boolean check = thisController.connectiontoDB("Login");   
        if(check == true){
            //if login successful open main frame
            new MainFrame().setVisible(true);
            dispose();
        }else{
            //if not successful show errormsg
            JOptionPane.showMessageDialog(this, thisController.errorMsg,
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField dbName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton loginBtn;
    public static javax.swing.JPasswordField password;
    public static javax.swing.JTextField port;
    public static javax.swing.JTextField url;
    public static javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}