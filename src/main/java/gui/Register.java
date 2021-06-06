package gui;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import config.Database;
import config.ImageConfig;
import config.User;
import app.MainMenu;

import javax.swing.*;

/**
 * @author danae
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        TextFieldUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TextFieldPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Slab SemiBold", 2, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 102));
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 190, 35));
        jPanel1.add(TextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 155, 34));

        jLabel3.setFont(new java.awt.Font("Roboto Slab ExtraBold", 2, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 102));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 180, 32));
        jPanel1.add(TextFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 155, 34));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 102));
        jButton1.setText("Register");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, 38));

        jButton2.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 255));
        jButton2.setText("Back to MeinMenu");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 300, 38));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(ImageConfig.LoginAndRegister))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, -10, 1090, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        MainMenu mainmenu = new MainMenu();
        this.setVisible(false);
        mainmenu.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        MainMenu mainmenu = new MainMenu();
        var username = TextFieldUsername.getText();
        var password = String.valueOf(TextFieldPassword.getPassword());
        if (!username.isBlank() && !password.isBlank()) {
            Database.insertIntoUser(new User(username, password));
            this.setVisible(false);
            mainmenu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "username or password is null", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField TextFieldPassword;
    private javax.swing.JTextField TextFieldUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}