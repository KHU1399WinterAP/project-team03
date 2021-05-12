package gui;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import app.MainMenu;
import config.Database;
import config.ImageConfig;
import config.User;

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
        setLocationRelativeTo(getRootPane());
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
        usernameLabel = new javax.swing.JLabel();
        textFieldUsername = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        textFieldPassword = new javax.swing.JPasswordField();
        registerButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLabel.setBackground(new java.awt.Color(255, 255, 153));
        usernameLabel.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 51, 102));
        usernameLabel.setText("Username");
        jPanel1.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 260, 35));
        jPanel1.add(textFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 155, 34));

        passwordLabel.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 51, 102));
        passwordLabel.setText("Password");
        jPanel1.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 230, 32));
        jPanel1.add(textFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 155, 34));

        registerButton.setBackground(new java.awt.Color(0, 255, 204));
        registerButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        registerButton.setText("Register");
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });
        jPanel1.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, 38));

        backButton.setBackground(new java.awt.Color(0, 255, 204));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setText("Back to MeinMenu");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 170, 38));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(ImageConfig.registerImage))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, -10, 1090, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        MainMenu mainmenu = new MainMenu();
        this.setVisible(false);
        mainmenu.setVisible(true);
    }//GEN-LAST:event_backButtonMouseClicked

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        var username = textFieldUsername.getText();
        var password = String.valueOf(textFieldPassword.getPassword());

        if (!username.isBlank() && !password.isBlank()) {
            Database.insertIntoUser(new User(username, password));
            this.setVisible(false);
            MainMenu mainmenu = new MainMenu();
            mainmenu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "username or password is null", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerButtonMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Register().setVisible(true);
//            }
//        });
//    }
    public void helloe(){

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JPasswordField textFieldPassword;
    private javax.swing.JTextField textFieldUsername;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}