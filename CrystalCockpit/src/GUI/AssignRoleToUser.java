/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.*;
import static Controller.Controller.connection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Shan 
 */
public class AssignRoleToUser extends javax.swing.JPanel {

    /**
     * Creates new form AssignRoleToUser
     */
    public AssignRoleToUser() {
        initComponents();
        /*Create Role*/
        r_password.setEnabled(false);
        scriptText_CR.setEnabled(false);
        /*End Create Role*/
        
        /*Delete Role*/
        scriptText_DR.setEnabled(false);
        //end delete role

        //Set Role
        label_SR.setVisible(false);
        Role_Name_SR.setVisible(false);
        scriptText_SR.setEnabled(false);
        password_SR.setVisible(false);
        label2_SR.setVisible(false);
        //End set Role
        
        //Alter Role
        userPanel_AR.setVisible(false);
        rolePanel_AR.setVisible(false);
        PasswordPanel_AR.setVisible(false);
        scriptText_AR.setEnabled(false);
        //End Alter Role         
        
        saveScript_CR.setEnabled(false);
        saveScript_DR.setEnabled(false);
        saveScript_SR.setEnabled(false);
        saveScript_AR.setEnabled(false);
        
        scriptText_CR.setDisabledTextColor(Color.BLACK);
        scriptText_DR.setDisabledTextColor(Color.BLACK);
        scriptText_SR.setDisabledTextColor(Color.BLACK);
        scriptText_AR.setDisabledTextColor(Color.BLACK);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        createRolePanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        roleNameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PasswordOptionBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scriptText_CR = new javax.swing.JTextArea();
        editScript_CR = new javax.swing.JButton();
        cancel_CR = new javax.swing.JButton();
        showscript_CR = new javax.swing.JButton();
        r_password = new javax.swing.JPasswordField();
        saveScript_CR = new javax.swing.JButton();
        deleteRolePanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        list_role_name = new javax.swing.JComboBox();
        deleteRoleButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        scriptText_DR = new javax.swing.JTextArea();
        showScript_DR = new javax.swing.JButton();
        editScript_DR = new javax.swing.JButton();
        cancel_DR = new javax.swing.JButton();
        saveScript_DR = new javax.swing.JButton();
        seRolePanel = new javax.swing.JPanel();
        setRoles_choice = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        Ok_SR = new javax.swing.JButton();
        cancel_SR = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        scriptText_SR = new javax.swing.JTextArea();
        showScript_SR = new javax.swing.JButton();
        label_SR = new javax.swing.JLabel();
        Role_Name_SR = new javax.swing.JComboBox();
        label2_SR = new javax.swing.JLabel();
        editScript_SR = new javax.swing.JButton();
        saveScript_SR = new javax.swing.JButton();
        password_SR = new javax.swing.JPasswordField();
        alterRoleUserPanel = new javax.swing.JPanel();
        Default_choice = new javax.swing.JComboBox();
        Ok_AR = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        scriptText_AR = new javax.swing.JTextArea();
        showScript_AR = new javax.swing.JButton();
        editScript_AR = new javax.swing.JButton();
        cancel_AR = new javax.swing.JButton();
        userPanel_AR = new javax.swing.JPanel();
        userName_AR = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        rolePanel_AR = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        roleName_AR = new javax.swing.JComboBox();
        PasswordPanel_AR = new javax.swing.JPanel();
        label3_AR = new javax.swing.JLabel();
        password_Ar = new javax.swing.JPasswordField();
        saveScript_AR = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        setEnabled(false);
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        createRolePanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                createRolePanelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        createButton.setText("Create ");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        createButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                createButtonKeyPressed(evt);
            }
        });

        jLabel2.setText("Role Name: ");

        jLabel3.setText("Optional");

        PasswordOptionBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        PasswordOptionBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PasswordOptionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordOptionBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Password:");

        scriptText_CR.setColumns(20);
        scriptText_CR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scriptText_CR.setRows(5);
        jScrollPane1.setViewportView(scriptText_CR);

        editScript_CR.setText("Edit Script");
        editScript_CR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editScript_CRActionPerformed(evt);
            }
        });
        editScript_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editScript_CRKeyPressed(evt);
            }
        });

        cancel_CR.setText("Cancel");
        cancel_CR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_CRActionPerformed(evt);
            }
        });
        cancel_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancel_CRKeyPressed(evt);
            }
        });

        showscript_CR.setText("Show Script");
        showscript_CR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showscript_CRActionPerformed(evt);
            }
        });
        showscript_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                showscript_CRKeyPressed(evt);
            }
        });

        saveScript_CR.setText("Save Script");
        saveScript_CR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveScript_CRActionPerformed(evt);
            }
        });
        saveScript_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveScript_CRKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout createRolePanelLayout = new javax.swing.GroupLayout(createRolePanel);
        createRolePanel.setLayout(createRolePanelLayout);
        createRolePanelLayout.setHorizontalGroup(
            createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createRolePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createRolePanelLayout.createSequentialGroup()
                        .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(47, 47, 47)
                        .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(createRolePanelLayout.createSequentialGroup()
                                .addComponent(PasswordOptionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(roleNameText, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(r_password))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(createRolePanelLayout.createSequentialGroup()
                        .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveScript_CR)
                            .addComponent(editScript_CR, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showscript_CR))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(createRolePanelLayout.createSequentialGroup()
                                .addComponent(cancel_CR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(60, Short.MAX_VALUE))))
        );
        createRolePanelLayout.setVerticalGroup(
            createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createRolePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(roleNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(r_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordOptionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(createRolePanelLayout.createSequentialGroup()
                        .addComponent(showscript_CR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editScript_CR)
                        .addGap(13, 13, 13)
                        .addComponent(saveScript_CR)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createButton)
                    .addComponent(cancel_CR))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Create Role", createRolePanel);

        deleteRolePanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                deleteRolePanelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel7.setText("Role Name:");

        list_role_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select One--" }));

        deleteRoleButton.setText("Delete");
        deleteRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoleButtonActionPerformed(evt);
            }
        });
        deleteRoleButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deleteRoleButtonKeyPressed(evt);
            }
        });

        scriptText_DR.setColumns(20);
        scriptText_DR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scriptText_DR.setRows(5);
        jScrollPane2.setViewportView(scriptText_DR);

        showScript_DR.setText("Show Script");
        showScript_DR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showScript_DRActionPerformed(evt);
            }
        });
        showScript_DR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                showScript_DRKeyPressed(evt);
            }
        });

        editScript_DR.setText("Edit Script");
        editScript_DR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editScript_DRActionPerformed(evt);
            }
        });
        editScript_DR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editScript_DRKeyPressed(evt);
            }
        });

        cancel_DR.setText("Cancel");
        cancel_DR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_DRActionPerformed(evt);
            }
        });
        cancel_DR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancel_DRKeyPressed(evt);
            }
        });

        saveScript_DR.setText("Save Script");
        saveScript_DR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveScript_DRActionPerformed(evt);
            }
        });
        saveScript_DR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveScript_DRKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout deleteRolePanelLayout = new javax.swing.GroupLayout(deleteRolePanel);
        deleteRolePanel.setLayout(deleteRolePanelLayout);
        deleteRolePanelLayout.setHorizontalGroup(
            deleteRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteRolePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(deleteRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteRolePanelLayout.createSequentialGroup()
                        .addComponent(cancel_DR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteRoleButton))
                    .addGroup(deleteRolePanelLayout.createSequentialGroup()
                        .addGroup(deleteRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editScript_DR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showScript_DR, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveScript_DR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(deleteRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(list_role_name, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        deleteRolePanelLayout.setVerticalGroup(
            deleteRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteRolePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(deleteRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(list_role_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(deleteRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deleteRolePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(deleteRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteRoleButton)
                            .addComponent(cancel_DR)))
                    .addGroup(deleteRolePanelLayout.createSequentialGroup()
                        .addComponent(showScript_DR)
                        .addGap(18, 18, 18)
                        .addComponent(editScript_DR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveScript_DR)))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delete Role", deleteRolePanel);

        seRolePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        seRolePanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                seRolePanelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        setRoles_choice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select One--", "Edit Role With Password", "Enable All Roles", "Enable All Except Role", "Disable All Roles " }));
        setRoles_choice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setRoles_choiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        Ok_SR.setText("Ok");
        Ok_SR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ok_SRActionPerformed(evt);
            }
        });
        Ok_SR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Ok_SRKeyPressed(evt);
            }
        });

        cancel_SR.setText("Cancel");
        cancel_SR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_SRActionPerformed(evt);
            }
        });
        cancel_SR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cancel_SRKeyReleased(evt);
            }
        });

        scriptText_SR.setColumns(20);
        scriptText_SR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scriptText_SR.setRows(5);
        jScrollPane3.setViewportView(scriptText_SR);

        showScript_SR.setText("Show Script");
        showScript_SR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showScript_SRActionPerformed(evt);
            }
        });
        showScript_SR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                showScript_SRKeyPressed(evt);
            }
        });

        label_SR.setText("Role:");

        Role_Name_SR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select One--" }));

        label2_SR.setText("Password:");

        editScript_SR.setText("Edit Script");
        editScript_SR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editScript_SRActionPerformed(evt);
            }
        });
        editScript_SR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editScript_SRKeyPressed(evt);
            }
        });

        saveScript_SR.setText("Save Script");
        saveScript_SR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveScript_SRActionPerformed(evt);
            }
        });
        saveScript_SR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveScript_SRKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout seRolePanelLayout = new javax.swing.GroupLayout(seRolePanel);
        seRolePanel.setLayout(seRolePanelLayout);
        seRolePanelLayout.setHorizontalGroup(
            seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seRolePanelLayout.createSequentialGroup()
                .addGroup(seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seRolePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(seRolePanelLayout.createSequentialGroup()
                                .addComponent(label_SR)
                                .addGap(29, 29, 29)
                                .addComponent(Role_Name_SR, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(seRolePanelLayout.createSequentialGroup()
                                .addComponent(label2_SR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(password_SR))
                            .addComponent(setRoles_choice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(seRolePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(seRolePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancel_SR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Ok_SR))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seRolePanelLayout.createSequentialGroup()
                                .addGroup(seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(seRolePanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(editScript_SR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(showScript_SR, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
                                    .addComponent(saveScript_SR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(88, 88, 88))
            .addGroup(seRolePanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        seRolePanelLayout.setVerticalGroup(
            seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seRolePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(setRoles_choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_SR)
                    .addComponent(Role_Name_SR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2_SR)
                    .addComponent(password_SR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(seRolePanelLayout.createSequentialGroup()
                        .addComponent(showScript_SR)
                        .addGap(18, 18, 18)
                        .addComponent(editScript_SR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveScript_SR))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(seRolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ok_SR)
                    .addComponent(cancel_SR))
                .addGap(136, 136, 136)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Set Role", seRolePanel);

        alterRoleUserPanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                alterRoleUserPanelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Default_choice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select One--", "User to default role", "User to all default role", "User to all default role except one role", "change role identification", "change role password" }));
        Default_choice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Default_choiceActionPerformed(evt);
            }
        });

        Ok_AR.setText("Ok");
        Ok_AR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ok_ARActionPerformed(evt);
            }
        });
        Ok_AR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Ok_ARKeyPressed(evt);
            }
        });

        scriptText_AR.setColumns(20);
        scriptText_AR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scriptText_AR.setRows(5);
        jScrollPane4.setViewportView(scriptText_AR);

        showScript_AR.setText("Show Script");
        showScript_AR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showScript_ARActionPerformed(evt);
            }
        });
        showScript_AR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                showScript_ARKeyPressed(evt);
            }
        });

        editScript_AR.setText("Edit Script");
        editScript_AR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editScript_ARActionPerformed(evt);
            }
        });
        editScript_AR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editScript_ARKeyPressed(evt);
            }
        });

        cancel_AR.setText("Cancel");
        cancel_AR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ARActionPerformed(evt);
            }
        });
        cancel_AR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancel_ARKeyPressed(evt);
            }
        });

        userName_AR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select One--" }));

        jLabel21.setText("User:");

        javax.swing.GroupLayout userPanel_ARLayout = new javax.swing.GroupLayout(userPanel_AR);
        userPanel_AR.setLayout(userPanel_ARLayout);
        userPanel_ARLayout.setHorizontalGroup(
            userPanel_ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanel_ARLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel21)
                .addGap(32, 32, 32)
                .addComponent(userName_AR, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userPanel_ARLayout.setVerticalGroup(
            userPanel_ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanel_ARLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(userPanel_ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName_AR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Role:");

        roleName_AR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select One--" }));

        javax.swing.GroupLayout rolePanel_ARLayout = new javax.swing.GroupLayout(rolePanel_AR);
        rolePanel_AR.setLayout(rolePanel_ARLayout);
        rolePanel_ARLayout.setHorizontalGroup(
            rolePanel_ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rolePanel_ARLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addComponent(roleName_AR, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        rolePanel_ARLayout.setVerticalGroup(
            rolePanel_ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rolePanel_ARLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(rolePanel_ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roleName_AR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label3_AR.setText("Password :");

        javax.swing.GroupLayout PasswordPanel_ARLayout = new javax.swing.GroupLayout(PasswordPanel_AR);
        PasswordPanel_AR.setLayout(PasswordPanel_ARLayout);
        PasswordPanel_ARLayout.setHorizontalGroup(
            PasswordPanel_ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PasswordPanel_ARLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label3_AR)
                .addGap(18, 18, 18)
                .addComponent(password_Ar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PasswordPanel_ARLayout.setVerticalGroup(
            PasswordPanel_ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordPanel_ARLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PasswordPanel_ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3_AR)
                    .addComponent(password_Ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        saveScript_AR.setText("Save Script");
        saveScript_AR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveScript_ARActionPerformed(evt);
            }
        });
        saveScript_AR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveScript_ARKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout alterRoleUserPanelLayout = new javax.swing.GroupLayout(alterRoleUserPanel);
        alterRoleUserPanel.setLayout(alterRoleUserPanelLayout);
        alterRoleUserPanelLayout.setHorizontalGroup(
            alterRoleUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alterRoleUserPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(alterRoleUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(alterRoleUserPanelLayout.createSequentialGroup()
                        .addComponent(cancel_AR)
                        .addGap(27, 27, 27)
                        .addComponent(Ok_AR))
                    .addGroup(alterRoleUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Default_choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(alterRoleUserPanelLayout.createSequentialGroup()
                            .addGroup(alterRoleUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(showScript_AR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editScript_AR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveScript_AR, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(alterRoleUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rolePanel_AR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(PasswordPanel_AR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userPanel_AR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        alterRoleUserPanelLayout.setVerticalGroup(
            alterRoleUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alterRoleUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Default_choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userPanel_AR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordPanel_AR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolePanel_AR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(alterRoleUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, alterRoleUserPanelLayout.createSequentialGroup()
                        .addComponent(showScript_AR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editScript_AR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveScript_AR))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(alterRoleUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ok_AR)
                    .addComponent(cancel_AR))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alter Role / User", alterRoleUserPanel);

        refresh.setIcon(thisController.refreshIcon(15));
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        refresh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                refreshKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refresh)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public Controller thisController = new Controller();
    boolean checkEdit_CR=false;
    boolean checkEdit_DR=false;
    int choice_SR=0;
    int choice_AR=0;
    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        retriveRoleNameFromDB();
        retriveUserFromDB();
    }//GEN-LAST:event_formAncestorAdded

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        retriveRoleNameFromDB();
        retriveUserFromDB();
    }//GEN-LAST:event_refreshActionPerformed

    private void setRoles_choiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setRoles_choiceActionPerformed
        
        if ("Enable All Roles".equals(setRoles_choice.getSelectedItem())){
            choice_SR=1;
            label_SR.setVisible(false);
            Role_Name_SR.setVisible(false);
            password_SR.setVisible(false);
            label2_SR.setVisible(false);
            //Ok_SR.doClick();
        }else if("Disable All Roles ".equals(setRoles_choice.getSelectedItem())){
            choice_SR=2;
            label_SR.setVisible(false);
            Role_Name_SR.setVisible(false);
            password_SR.setVisible(false);
            label2_SR.setVisible(false);
            //Ok_SR.doClick();
        }else if("Enable All Except Role".equals(setRoles_choice.getSelectedItem())){
            choice_SR=3;
            label_SR.setVisible(true);
            Role_Name_SR.setVisible(true);
            password_SR.setVisible(false);
            label2_SR.setVisible(false);
        }else if("Edit Role With Password".equals(setRoles_choice.getSelectedItem())){
            choice_SR=4;
            label_SR.setVisible(true);
            Role_Name_SR.setVisible(true);
            password_SR.setVisible(true);
            label2_SR.setVisible(true);
        }else if("--Please Select One--".equals(setRoles_choice.getSelectedItem())){
            choice_SR=0;
            label_SR.setVisible(false);
            Role_Name_SR.setVisible(false);
            password_SR.setVisible(false);
            label2_SR.setVisible(false);
        }
    }//GEN-LAST:event_setRoles_choiceActionPerformed

    private void PasswordOptionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordOptionBoxActionPerformed

        if ("No".equals( PasswordOptionBox.getSelectedItem())){
            r_password.setEnabled(false);
        }else {
            r_password.setEnabled(true);
        }
    }//GEN-LAST:event_PasswordOptionBoxActionPerformed

    private void createButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createButtonKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            createButton.doClick();
        }
    }//GEN-LAST:event_createButtonKeyPressed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        if(checkEdit_CR==false){
            action();
        }else if(checkEdit_CR==true){
            boolean success;
            thisController.connectiontoDB("openConn");
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you "
                    + "want to create this role ?",
                "Click Yes or No", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                try {
                    String script =  scriptText_CR.getText(); 
                    PreparedStatement st = connection.prepareStatement(script);
                    st.executeUpdate();
                    thisController.history(script);
                    success=true;
           }catch (SQLException ex)
           {
               JOptionPane.showMessageDialog(this,ex.getMessage());
               success=false;
           }
           if(success==true){
               
               scriptText_CR.setText("");
               JOptionPane.showMessageDialog(this, "New Role Created");
               cancel_CR.doClick();
           }
         }
       }    
    }//GEN-LAST:event_createButtonActionPerformed

    private void Ok_ARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Ok_ARKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Ok_AR.doClick();
        }
    }//GEN-LAST:event_Ok_ARKeyPressed

    private void Ok_ARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ok_ARActionPerformed

                
        if(Default_choice.getSelectedIndex()!=0){
            
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to do this? ", 
                "Click Yes or No", JOptionPane.YES_NO_OPTION);

        if(reply == JOptionPane.YES_OPTION){
            if(choice_AR==1 && userName_AR.getSelectedIndex()!=0  
                && roleName_AR.getSelectedIndex()!=0){//User to default role
                Boolean check = thisController.connectiontoDB("DefaultOneRole");
                if(check == true){
                    JOptionPane.showMessageDialog(this,"Role Altered");
                    thisController.history(thisController.defaultOneRole());
                }else{
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
            }else if(choice_AR==2 && userName_AR.getSelectedIndex()!=0){//User to all default role
                  Boolean check = thisController.connectiontoDB("Default_All_Role");
                if(check == true){
                    JOptionPane.showMessageDialog(this,"Role Altered");
                    thisController.history(thisController.default_All_Role());
                }else{
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
            }else if(choice_AR==3 && userName_AR.getSelectedIndex()!=0
                && roleName_AR.getSelectedIndex()!=0){//User to all default role except one role
                Boolean check = thisController.connectiontoDB("Default_Except_Role");
                if(check == true){
                    JOptionPane.showMessageDialog(this,"Role Altered");
                    thisController.history(thisController.default_Except_Role());
                }else{
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
            }else if(choice_AR==4  
                && roleName_AR.getSelectedIndex()!=0){
                Boolean check = thisController.connectiontoDB("changeRoleID");
                if(check == true){
                    JOptionPane.showMessageDialog(this,"Role Altered");
                    thisController.history(thisController.changeRoleID());
                }else{
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
            }else if(choice_AR==5 && roleName_AR.getSelectedIndex()!=0 
                && password_Ar.getText().length()!=0){
                Boolean check = thisController.connectiontoDB("changeRolePass");
                if(check == true){
                    JOptionPane.showMessageDialog(this,"Role Altered");
                    thisController.history(thisController.changeRolePass());
                }else{
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
            }else if(choice_AR==6){
                boolean success;
                thisController.connectiontoDB("openConn");
                try {
                    String script =  scriptText_AR.getText(); 
                    PreparedStatement st = connection.prepareStatement(script);
                    st.executeUpdate();
                    thisController.history(script);
                    success=true;
                }catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(this,ex.getMessage());
                    success=false;
                }
                if(success==true){
                    JOptionPane.showMessageDialog(this, "Done");
                    cancel_AR.doClick();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Please fill up correct information.");
            }
        }
        }else{
            JOptionPane.showMessageDialog(this, "Please fill up correct informatio.");
        }
    }//GEN-LAST:event_Ok_ARActionPerformed

    private void Default_choiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Default_choiceActionPerformed
        if("User to default role".equals(Default_choice.getSelectedItem())){
            userPanel_AR.setVisible(true);
            userName_AR.setSelectedIndex(0);
            rolePanel_AR.setVisible(true);
            roleName_AR.setSelectedIndex(0);
            PasswordPanel_AR.setVisible(false);
            choice_AR=1;
        }else if("User to all default role".equals(Default_choice.getSelectedItem())){
            userPanel_AR.setVisible(true);
            userName_AR.setSelectedIndex(0);
            rolePanel_AR.setVisible(false);
            PasswordPanel_AR.setVisible(false);
            choice_AR=2;
        }else if("User to all default role except one role".equals(Default_choice.getSelectedItem())){
            userPanel_AR.setVisible(true);
            userName_AR.setSelectedIndex(0);
            rolePanel_AR.setVisible(true);
            roleName_AR.setSelectedIndex(0);
            PasswordPanel_AR.setVisible(false);
            choice_AR=3;
        }else if("change role identification".equals(Default_choice.getSelectedItem())){
            rolePanel_AR.setVisible(true);
            roleName_AR.setSelectedIndex(0);
            userPanel_AR.setVisible(false);
            PasswordPanel_AR.setVisible(false);
            choice_AR=4;
        }else if("change role password".equals(Default_choice.getSelectedItem())){
            rolePanel_AR.setVisible(true);
            roleName_AR.setSelectedIndex(0);
            userPanel_AR.setVisible(false);
            PasswordPanel_AR.setVisible(true);
            choice_AR=5;
        }else if("--Please Select One--".equals(Default_choice.getSelectedItem())){
            rolePanel_AR.setVisible(false);
            userPanel_AR.setVisible(false);
            PasswordPanel_AR.setVisible(false);
            choice_AR=0;
        }
    }//GEN-LAST:event_Default_choiceActionPerformed

    private void deleteRoleButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteRoleButtonKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            deleteRoleButton.doClick();
        }
    }//GEN-LAST:event_deleteRoleButtonKeyPressed

    private void deleteRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoleButtonActionPerformed

        if(checkEdit_DR==false){
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you would like to drop "
                    +(String) list_role_name.getSelectedItem(), 
                    "Click Yes or No", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                Boolean check = thisController.connectiontoDB("Delete_Role");
                if(check == true){
                    JOptionPane.showMessageDialog(this, "Role Drop");
                    thisController.history(thisController.delete_Role());
                }else{
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if(checkEdit_DR==true){
            boolean success;
            thisController.connectiontoDB("openConn");
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to drop this role ?",
                "Click Yes or No", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                try {
                    String script =  scriptText_DR.getText(); 
                    PreparedStatement st = connection.prepareStatement(script);
                    thisController.history(script);
                     st.executeUpdate();
                     success=true;
                }catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(this,ex.getMessage());
                    success=false;
                }
                if(success==true){
                    JOptionPane.showMessageDialog(this, "Role Dropped");
                    cancel_DR.doClick();
                }
            }
        }
    }//GEN-LAST:event_deleteRoleButtonActionPerformed

    private void showscript_CRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showscript_CRActionPerformed
       if(roleNameText.getText()!="" && PasswordOptionBox.getSelectedItem()=="No"){
            scriptText_CR.setText("Create Role "+roleNameText.getText());
        }else if(roleNameText.getText()!="" && PasswordOptionBox.getSelectedItem()=="Yes")
        {
              scriptText_CR.setText("Create Role "+roleNameText.getText()+
                      "\nIdentified By "+r_password.getText()); 
        }
       saveScript_CR.setEnabled(true);
    }//GEN-LAST:event_showscript_CRActionPerformed

    private void editScript_CRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editScript_CRActionPerformed
        showscript_CR.doClick();
        scriptText_CR.setEnabled(true);
        checkEdit_CR=true;
        roleNameText.setEnabled(false);
        r_password.setEnabled(false);
        PasswordOptionBox.setEnabled(false);
        saveScript_CR.setEnabled(true);
    }//GEN-LAST:event_editScript_CRActionPerformed

    private void cancel_CRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_CRActionPerformed
        scriptText_CR.setEnabled(false);
        scriptText_CR.setText("");
        checkEdit_CR=false;
        roleNameText.setEnabled(true);
        roleNameText.setText("");
        PasswordOptionBox.setEnabled(true);
        r_password.setText("");
        PasswordOptionBox.setSelectedItem("No");
        saveScript_CR.setEnabled(false);
    }//GEN-LAST:event_cancel_CRActionPerformed

    private void showScript_DRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScript_DRActionPerformed
        scriptText_DR.setText("Drop Role "+list_role_name.getSelectedItem());
        saveScript_DR.setEnabled(true);
    }//GEN-LAST:event_showScript_DRActionPerformed

    private void cancel_DRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_DRActionPerformed
        checkEdit_DR=false;
        retriveRoleNameFromDB();
        scriptText_DR.setText("");
        scriptText_DR.setEnabled(false);
        saveScript_DR.setEnabled(false);
    }//GEN-LAST:event_cancel_DRActionPerformed

    private void editScript_DRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editScript_DRActionPerformed
        showScript_DR.doClick();
        checkEdit_DR=true;
        scriptText_DR.setEnabled(true);
        saveScript_DR.setEnabled(true);
    }//GEN-LAST:event_editScript_DRActionPerformed

    private void Ok_SRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ok_SRActionPerformed
     
        if(setRoles_choice.getSelectedIndex()!= 0){
        if(choice_SR==1){
         int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to enable to all roles?", 
                "Click Yes or No", JOptionPane.YES_NO_OPTION);
         if(reply == JOptionPane.YES_OPTION){
            Boolean check = thisController.connectiontoDB("Enable_All_Role");
            if(check == true){
                JOptionPane.showMessageDialog(this, "Done!!");
                thisController.history(thisController.enable_All_Role());
                cancel_SR.doClick();
            }else{
                JOptionPane.showMessageDialog(this, thisController.errorMsg,
                   "Error",JOptionPane.ERROR_MESSAGE);
            }
         }
       }else if(choice_SR==2){
           int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to disable all roles?", 
                "Click Yes or No", JOptionPane.YES_NO_OPTION);
           if(reply == JOptionPane.YES_OPTION){
               Boolean check = thisController.connectiontoDB("Disable_All_Role");
               if(check == true){
                   JOptionPane.showMessageDialog(this, "Done!!");
                   thisController.history(thisController.disable_All_Role());
                    cancel_SR.doClick();
                }else{
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
            }   
       }else if(choice_SR==3 && Role_Name_SR.getSelectedIndex()!=0){
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to do this?", 
                "Click Yes or No", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                Boolean check = thisController.connectiontoDB("Except_Role");
                if(check == true){
                    JOptionPane.showMessageDialog(this, "Done!!");
                    thisController.history(thisController.except_Role());
                    cancel_SR.doClick();
                }else{
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
       }else if(choice_SR==4 &&Role_Name_SR.getSelectedIndex()!=0
                && password_SR.getText().length()!=0){
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to do this?", 
                "Click Yes or No", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                Boolean check = thisController.connectiontoDB("SetRoleWithPassword");
                if(check == true){
                    JOptionPane.showMessageDialog(this, "Done!!");
                    thisController.history(thisController.setRoleWithPassword());
                    cancel_SR.doClick();
                }else{
                    JOptionPane.showMessageDialog(this, thisController.errorMsg,
                        "Error",JOptionPane.ERROR_MESSAGE);
                }   
            }
       }else if(choice_SR==5){
           boolean success;
           thisController.connectiontoDB("openConn");
           int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to do this ?",
                "Click Yes or No", JOptionPane.YES_NO_OPTION);
           if(reply == JOptionPane.YES_OPTION){
               try {
                   String script =  scriptText_SR.getText(); 
                   PreparedStatement st = connection.prepareStatement(script);
                   st.executeUpdate();
                   thisController.history(script);
                   success=true;
                }catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(this,ex.getMessage());
                    success=false;
                }
               if(success==true){
                    JOptionPane.showMessageDialog(this, "Done");
                    cancel_SR.doClick();
                }
            }
        }else{
           JOptionPane.showMessageDialog(this, "Please fill up correct information.");
       }
        }else{
            JOptionPane.showMessageDialog(this, "Please choice one Role.");
        }
    }//GEN-LAST:event_Ok_SRActionPerformed

    private void cancel_SRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_SRActionPerformed
       choice_SR=0;
       setRoles_choice.setSelectedItem("--Please Select One--");
       scriptText_SR.setEnabled(false);
       scriptText_SR.setText("");
       label_SR.setVisible(false);
       Role_Name_SR.setVisible(false);
       password_SR.setVisible(false);
       label2_SR.setVisible(false);
       saveScript_SR.setEnabled(false);
    }//GEN-LAST:event_cancel_SRActionPerformed

    private void showScript_SRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScript_SRActionPerformed
        if(choice_SR==1 ){//Enable All Roles
            scriptText_SR.setText("Set Role All");
        }else if(choice_SR==2){//Disable All Roles
             scriptText_SR.setText("Set Role None");
        }else if(choice_SR==3){//Enable All Except Role
            scriptText_SR.setText("Set Role All Except "+Role_Name_SR.getSelectedItem());
        }else if(choice_SR==4){//Edit Role With Password
             scriptText_SR.setText("Set Role "+Role_Name_SR.getSelectedItem()
                     +"\nIdentified by "+password_SR.getText());
        }
        saveScript_SR.setEnabled(true);
    }//GEN-LAST:event_showScript_SRActionPerformed

    private void editScript_SRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editScript_SRActionPerformed
        showScript_SR.doClick();
        scriptText_SR.setEnabled(true);
        choice_SR=5;
        saveScript_SR.setEnabled(true);
    }//GEN-LAST:event_editScript_SRActionPerformed

    private void showScript_ARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScript_ARActionPerformed
       if(choice_AR==1){//User to default role
           scriptText_AR.setText("Alter User "+userName_AR.getSelectedItem()
                   +"\nDefault Role "+roleName_AR.getSelectedItem());
       }else if(choice_AR==2){//User to all default role
          scriptText_AR.setText("Alter User "+userName_AR.getSelectedItem()
                   +"\nDefault Role All");
       }else if(choice_AR==3){//User to all default role except one role
         scriptText_AR.setText("Alter User "+userName_AR.getSelectedItem()
                   +"\nDefault Role All \nExcept "+roleName_AR.getSelectedItem());
       }else if(choice_AR==4){//change role identification
         scriptText_AR.setText("Alter Role "+roleName_AR.getSelectedItem()
                   +"\nNot Identified");
       }else if(choice_AR==5){//change role password
         scriptText_AR.setText("Alter Role "+roleName_AR.getSelectedItem()
                   +"\nIdentified By "+password_Ar.getText());
       }
       saveScript_AR.setEnabled(true);
    }//GEN-LAST:event_showScript_ARActionPerformed

    private void editScript_ARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editScript_ARActionPerformed
       scriptText_AR.setEnabled(true);
       userPanel_AR.setVisible(false);
       rolePanel_AR.setVisible(false);
       PasswordPanel_AR.setVisible(false);
       choice_AR=6;
       saveScript_AR.setEnabled(true);
    }//GEN-LAST:event_editScript_ARActionPerformed

    private void cancel_ARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ARActionPerformed
       choice_AR=0;
       Default_choice.setSelectedItem("--Please Select One--");
       scriptText_AR.setText("");
       password_Ar.setText("");
       saveScript_AR.setEnabled(false);
    }//GEN-LAST:event_cancel_ARActionPerformed

    private void deleteRolePanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_deleteRolePanelAncestorAdded
        retriveRoleNameFromDB();
        retriveUserFromDB();
    }//GEN-LAST:event_deleteRolePanelAncestorAdded

    private void seRolePanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_seRolePanelAncestorAdded
        retriveRoleNameFromDB();
        retriveUserFromDB();
        cancel_SR.doClick();
    }//GEN-LAST:event_seRolePanelAncestorAdded

    private void alterRoleUserPanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_alterRoleUserPanelAncestorAdded
        retriveRoleNameFromDB();
        retriveUserFromDB();
        cancel_AR.doClick();
    }//GEN-LAST:event_alterRoleUserPanelAncestorAdded

    private void saveScript_CRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveScript_CRActionPerformed

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
                thisController.writeScrpitForSave(saveScriptPath,scriptText_CR.getText());
            }else{
                saveScriptPath = saveScriptPath+".sql";
                thisController.writeScrpitForSave(saveScriptPath,scriptText_CR.getText());
            }
            JOptionPane.showMessageDialog(null, "Script is Saved.");
        }
    }//GEN-LAST:event_saveScript_CRActionPerformed

    private void saveScript_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveScript_CRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            saveScript_CR.doClick();
        }
    }//GEN-LAST:event_saveScript_CRKeyPressed

    private void saveScript_DRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveScript_DRActionPerformed

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
                thisController.writeScrpitForSave(saveScriptPath,scriptText_DR.getText());
            }else{
                saveScriptPath = saveScriptPath+".sql";
                thisController.writeScrpitForSave(saveScriptPath,scriptText_DR.getText());
            }
            JOptionPane.showMessageDialog(null, "Script is Saved.");
        }
    }//GEN-LAST:event_saveScript_DRActionPerformed

    private void saveScript_DRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveScript_DRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            saveScript_DR.doClick();
        }
    }//GEN-LAST:event_saveScript_DRKeyPressed

    private void saveScript_SRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveScript_SRActionPerformed

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
                thisController.writeScrpitForSave(saveScriptPath,scriptText_SR.getText());
            }else{
                saveScriptPath = saveScriptPath+".sql";
                thisController.writeScrpitForSave(saveScriptPath,scriptText_SR.getText());
            }
            JOptionPane.showMessageDialog(null, "Script is Saved.");
        }
    }//GEN-LAST:event_saveScript_SRActionPerformed

    private void saveScript_SRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveScript_SRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            saveScript_SR.doClick();
        }
    }//GEN-LAST:event_saveScript_SRKeyPressed

    private void saveScript_ARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveScript_ARActionPerformed
        
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
                thisController.writeScrpitForSave(saveScriptPath,scriptText_AR.getText());
            }else{
                saveScriptPath = saveScriptPath+".sql";
                thisController.writeScrpitForSave(saveScriptPath,scriptText_AR.getText());
            }
            JOptionPane.showMessageDialog(null, "Script is Saved.");
        }
    }//GEN-LAST:event_saveScript_ARActionPerformed

    private void showscript_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showscript_CRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            showscript_CR.doClick();
        }
    }//GEN-LAST:event_showscript_CRKeyPressed

    private void editScript_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editScript_CRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            editScript_CR.doClick();
        }
    }//GEN-LAST:event_editScript_CRKeyPressed

    private void cancel_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancel_CRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cancel_CR.doClick();
        }
    }//GEN-LAST:event_cancel_CRKeyPressed

    private void refreshKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refreshKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            refresh.doClick();
        }
    }//GEN-LAST:event_refreshKeyPressed

    private void showScript_DRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showScript_DRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            showScript_DR.doClick();
        }
    }//GEN-LAST:event_showScript_DRKeyPressed

    private void editScript_DRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editScript_DRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            editScript_DR.doClick();
        }
    }//GEN-LAST:event_editScript_DRKeyPressed

    private void cancel_DRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancel_DRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cancel_DR.doClick();
        }
    }//GEN-LAST:event_cancel_DRKeyPressed

    private void showScript_SRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showScript_SRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            showScript_SR.doClick();
        }
    }//GEN-LAST:event_showScript_SRKeyPressed

    private void editScript_SRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editScript_SRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            showScript_SR.doClick();
        }
    }//GEN-LAST:event_editScript_SRKeyPressed

    private void cancel_SRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancel_SRKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cancel_SR.doClick();
        }
    }//GEN-LAST:event_cancel_SRKeyReleased

    private void Ok_SRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Ok_SRKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Ok_SR.doClick();
        }
    }//GEN-LAST:event_Ok_SRKeyPressed

    private void showScript_ARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showScript_ARKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            showScript_AR.doClick();
        }
    }//GEN-LAST:event_showScript_ARKeyPressed

    private void editScript_ARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editScript_ARKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            editScript_AR.doClick();
        }
    }//GEN-LAST:event_editScript_ARKeyPressed

    private void saveScript_ARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveScript_ARKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            saveScript_AR.doClick();
        }
    }//GEN-LAST:event_saveScript_ARKeyPressed

    private void cancel_ARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancel_ARKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cancel_AR.doClick();
        }
    }//GEN-LAST:event_cancel_ARKeyPressed

    private void createRolePanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_createRolePanelAncestorAdded
        cancel_CR.doClick();
    }//GEN-LAST:event_createRolePanelAncestorAdded

    public void retriveRoleNameFromDB(){
        thisController.connectiontoDB("getRole");
        
        //set the combo box with this array
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.addAll(thisController.arrList);
        
        list_role_name.removeAllItems();
        Role_Name_SR.removeAllItems();
        roleName_AR.removeAllItems();
        
        list_role_name.addItem("--Please Select One--");
        Role_Name_SR.addItem("--Please Select One--");
        roleName_AR.addItem("--Please Select One--");
        
        for(int i = 0; i<arrList.size();i++){
            list_role_name.addItem(arrList.get(i));
            Role_Name_SR.addItem(arrList.get(i));
            roleName_AR.addItem(arrList.get(i));
        }
    }
    
   public void retriveUserFromDB(){
        thisController.connectiontoDB("get_User");
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.addAll(thisController.arrList);

        userName_AR.removeAllItems();
        userName_AR.addItem("--Please Select One--");
        
        for(int i = 0; i<arrList.size();i++){
            userName_AR.addItem(arrList.get(i));
        }      
    }
   
    private void action(){
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you would like to create "
                +(String) roleNameText.getText(), 
                "Click Yes or No", JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION){
            if(roleNameText.getText()!= null && r_password.getText()!=null){
                Boolean check = thisController.connectiontoDB("AssignRoleToUser");
                if(check == true){
                    JOptionPane.showMessageDialog(this, "New Role Created");
                    thisController.history(thisController.assignRoleToUser());
                    //To check if the option is No, User still able to create role
                }else if(roleNameText!= null && "No".equals( PasswordOptionBox.getSelectedItem())){
                    Boolean Anothercheck = thisController.connectiontoDB("AssignRoleToUserNoPassword");
                    if(Anothercheck == true){
                        JOptionPane.showMessageDialog(this, "New Role Created");
                    }else{
                        JOptionPane.showMessageDialog(this, thisController.errorMsg,
                            "Error",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                     JOptionPane.showMessageDialog(this, thisController.errorMsg,
                    "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Default_choice;
    private javax.swing.JButton Ok_AR;
    private javax.swing.JButton Ok_SR;
    private javax.swing.JComboBox PasswordOptionBox;
    private javax.swing.JPanel PasswordPanel_AR;
    public static javax.swing.JComboBox Role_Name_SR;
    private javax.swing.JPanel alterRoleUserPanel;
    private javax.swing.JButton cancel_AR;
    private javax.swing.JButton cancel_CR;
    private javax.swing.JButton cancel_DR;
    private javax.swing.JButton cancel_SR;
    private javax.swing.JButton createButton;
    public static javax.swing.JPanel createRolePanel;
    private javax.swing.JButton deleteRoleButton;
    private javax.swing.JPanel deleteRolePanel;
    private javax.swing.JButton editScript_AR;
    private javax.swing.JButton editScript_CR;
    private javax.swing.JButton editScript_DR;
    private javax.swing.JButton editScript_SR;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label2_SR;
    private javax.swing.JLabel label3_AR;
    private javax.swing.JLabel label_SR;
    public static javax.swing.JComboBox list_role_name;
    public static javax.swing.JPasswordField password_Ar;
    public static javax.swing.JPasswordField password_SR;
    public static javax.swing.JPasswordField r_password;
    private javax.swing.JButton refresh;
    public static javax.swing.JTextField roleNameText;
    public static javax.swing.JComboBox roleName_AR;
    private javax.swing.JPanel rolePanel_AR;
    private javax.swing.JButton saveScript_AR;
    private javax.swing.JButton saveScript_CR;
    private javax.swing.JButton saveScript_DR;
    private javax.swing.JButton saveScript_SR;
    private javax.swing.JTextArea scriptText_AR;
    private javax.swing.JTextArea scriptText_CR;
    private javax.swing.JTextArea scriptText_DR;
    private javax.swing.JTextArea scriptText_SR;
    public static javax.swing.JPanel seRolePanel;
    private javax.swing.JComboBox setRoles_choice;
    private javax.swing.JButton showScript_AR;
    private javax.swing.JButton showScript_DR;
    private javax.swing.JButton showScript_SR;
    private javax.swing.JButton showscript_CR;
    public static javax.swing.JComboBox userName_AR;
    private javax.swing.JPanel userPanel_AR;
    // End of variables declaration//GEN-END:variables
    }