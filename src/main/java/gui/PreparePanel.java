/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import config.ImageConfig;
import config.MusicConfig;
import utils.SoundAndMusic;

/**
 *
 * @author danae
 */
public class PreparePanel extends javax.swing.JFrame {
    PlantsVsZombies i;
    /**
     * Creates new form PreparePanel1
     */
    public PreparePanel() {
        initComponents();
        this.i = i;
//        BGM.StartPlay_BGM();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EasyButton = new javax.swing.JButton();
        NormalButton = new javax.swing.JButton();
        HardButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EasyButton.setBackground(new java.awt.Color(255, 204, 0));
        EasyButton.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 36)); // NOI18N
        EasyButton.setText("Easy");
        EasyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EasyButtonMouseClicked(evt);
            }
        });
        getContentPane().add(EasyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 200, 60));

        NormalButton.setBackground(new java.awt.Color(255, 204, 0));
        NormalButton.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 36)); // NOI18N
        NormalButton.setText("Normal");
        NormalButton.setMaximumSize(new java.awt.Dimension(107, 57));
        NormalButton.setMinimumSize(new java.awt.Dimension(107, 57));
        NormalButton.setPreferredSize(new java.awt.Dimension(107, 57));
        NormalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NormalButtonMouseClicked(evt);
            }
        });
        getContentPane().add(NormalButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 200, 60));

        HardButton.setBackground(new java.awt.Color(255, 204, 0));
        HardButton.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 36)); // NOI18N
        HardButton.setText("Hard");
        HardButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HardButtonMouseClicked(evt);
            }
        });
        getContentPane().add(HardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, 200, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(ImageConfig.preparePanel))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 634));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EasyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EasyButtonMouseClicked
        mood(10,5,"Easy");
    }//GEN-LAST:event_EasyButtonMouseClicked

    private void NormalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NormalButtonMouseClicked
        mood(20,7,"Normal");
    }//GEN-LAST:event_NormalButtonMouseClicked

    private void HardButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HardButtonMouseClicked
        mood(30,10,"Hard");
    }//GEN-LAST:event_HardButtonMouseClicked
    private void mood(int zombieNumber,int zombieRandomNumber,String mood){
        SoundAndMusic a = new SoundAndMusic(MusicConfig.laugh);
        a.playSound(MusicConfig.laugh);
        i = new PlantsVsZombies();
//        BGM.StopPlay_BGM();
        i.pvz_game = new GameField(i);
        i.pvz_game.newGame(zombieNumber, zombieRandomNumber);
        System.out.println(mood);
        this.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */

    private javax.swing.JButton EasyButton;
    private javax.swing.JButton HardButton;
    private javax.swing.JButton NormalButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}