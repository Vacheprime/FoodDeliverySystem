/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.users.Client;
import javax.swing.ImageIcon;

/**
 *
 * @author shahi
 */
public class FormHotDogMenu extends javax.swing.JFrame {

    Client client;
    Order order;
    ImageIcon glizzyImg = new ImageIcon("FoodDeliverySystem/glizzy.jpg");
    ImageIcon millimeter = new ImageIcon("FoodDeliverySystem/millimeter.jpg");
    /**
     * Creates new form frmHotDogMenu
     */
    public FormHotDogMenu(Client client, Order order) {
        initComponents();
        this.client = client;
        this.order = order;
        glizzyLblImg.setText("");
        glizzyLblImg.setIcon(glizzyImg);
        millimeterLblImg.setText("");
        millimeterLblImg.setIcon(millimeter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        langBtn = new javax.swing.JButton();
        hotdogMenuLbl = new javax.swing.JLabel();
        glizzyGobblerLbl = new javax.swing.JLabel();
        glizzyLblImg = new javax.swing.JLabel();
        millimeterDefeaterLbl = new javax.swing.JLabel();
        millimeterLblImg = new javax.swing.JLabel();
        glizzyBtn = new javax.swing.JButton();
        millimeterBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        langBtn.setText("French");
        langBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langBtnActionPerformed(evt);
            }
        });

        hotdogMenuLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        hotdogMenuLbl.setText("HotDog Menu");

        glizzyGobblerLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        glizzyGobblerLbl.setText("Glizzy Gobbler");

        glizzyLblImg.setText("jLabel2");

        millimeterDefeaterLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        millimeterDefeaterLbl.setText("Millimeter Defeater");

        millimeterLblImg.setText("jLabel4");

        glizzyBtn.setText("Add to cart");
        glizzyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glizzyBtnActionPerformed(evt);
            }
        });

        millimeterBtn.setText("Add to cart");
        millimeterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                millimeterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(glizzyGobblerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE))
                            .addComponent(glizzyLblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(millimeterLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(millimeterDefeaterLbl)
                                .addGap(127, 127, 127))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addGap(30, 30, 30)
                        .addComponent(hotdogMenuLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(langBtn)
                        .addGap(117, 117, 117))))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(glizzyBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(millimeterBtn)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(langBtn)
                    .addComponent(hotdogMenuLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(glizzyGobblerLbl)
                    .addComponent(millimeterDefeaterLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(millimeterLblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(glizzyLblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(glizzyBtn)
                    .addComponent(millimeterBtn))
                .addGap(408, 408, 408))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        new FormClientMainMenu(client, order).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void langBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_langBtnActionPerformed

    private void glizzyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glizzyBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_glizzyBtnActionPerformed

    private void millimeterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_millimeterBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_millimeterBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton glizzyBtn;
    private javax.swing.JLabel glizzyGobblerLbl;
    private javax.swing.JLabel glizzyLblImg;
    private javax.swing.JLabel hotdogMenuLbl;
    private javax.swing.JButton langBtn;
    private javax.swing.JButton millimeterBtn;
    private javax.swing.JLabel millimeterDefeaterLbl;
    private javax.swing.JLabel millimeterLblImg;
    // End of variables declaration//GEN-END:variables
}
