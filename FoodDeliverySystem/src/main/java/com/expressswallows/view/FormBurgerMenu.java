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
public class FormBurgerMenu extends javax.swing.JFrame {

    Client client;
    Order order;
    ImageIcon bigFatty = new ImageIcon("FoodDeliverySystem/bigfatty.jpg");
    ImageIcon greenBush = new ImageIcon("FoodDeliverySystem/greenbush.jpg");
    ImageIcon skinnyPity = new ImageIcon("FoodDeliverySystem/skinnypity.jpg");
    
    
    
    /**
     * Creates new form frmBurgerMenu
     */
    public FormBurgerMenu(Client client,Order order) {
        initComponents();
        this.client = client;
        this.order = order;
        bigFattyImg.setText("");
        bigFattyImg.setIcon(bigFatty);
        greenBushImg.setText("");
        greenBushImg.setIcon(greenBush);
        skinnyPityImg.setText("");
        skinnyPityImg.setIcon(skinnyPity);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        burgerMenuLbl = new javax.swing.JLabel();
        langBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        bigFattyLbl = new javax.swing.JLabel();
        bigFattyImg = new javax.swing.JLabel();
        bigFattyBtn = new javax.swing.JButton();
        greenBushImg = new javax.swing.JLabel();
        greenBushBtn = new javax.swing.JButton();
        greenBushLbl = new javax.swing.JLabel();
        skinnyPityImg = new javax.swing.JLabel();
        skinnyPityBtn = new javax.swing.JButton();
        bigFattyLbl1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        burgerMenuLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        burgerMenuLbl.setText("Burger Menu");

        langBtn.setText("French");
        langBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        bigFattyLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bigFattyLbl.setText("Big Fatty");

        bigFattyImg.setText("jLabel1");

        bigFattyBtn.setText("Add to cart");
        bigFattyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bigFattyBtnActionPerformed(evt);
            }
        });

        greenBushImg.setText("jLabel1");

        greenBushBtn.setText("Add to cart");
        greenBushBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenBushBtnActionPerformed(evt);
            }
        });

        greenBushLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        greenBushLbl.setText("Green Bush");

        skinnyPityImg.setText("jLabel1");

        skinnyPityBtn.setText("Add to cart");
        skinnyPityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinnyPityBtnActionPerformed(evt);
            }
        });

        bigFattyLbl1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bigFattyLbl1.setText("Skinny Pity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bigFattyImg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(bigFattyLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(bigFattyBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(burgerMenuLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(langBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(greenBushImg, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(greenBushBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(greenBushLbl)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(bigFattyLbl1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(skinnyPityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skinnyPityImg, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(langBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(burgerMenuLbl))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bigFattyLbl)
                    .addComponent(greenBushLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bigFattyImg)
                    .addComponent(greenBushImg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bigFattyBtn)
                    .addComponent(greenBushBtn))
                .addGap(27, 27, 27)
                .addComponent(bigFattyLbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skinnyPityImg, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(skinnyPityBtn)
                .addContainerGap(201, Short.MAX_VALUE))
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

    private void bigFattyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bigFattyBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bigFattyBtnActionPerformed

    private void greenBushBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenBushBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_greenBushBtnActionPerformed

    private void skinnyPityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinnyPityBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skinnyPityBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton bigFattyBtn;
    private javax.swing.JLabel bigFattyImg;
    private javax.swing.JLabel bigFattyLbl;
    private javax.swing.JLabel bigFattyLbl1;
    private javax.swing.JLabel burgerMenuLbl;
    private javax.swing.JButton greenBushBtn;
    private javax.swing.JLabel greenBushImg;
    private javax.swing.JLabel greenBushLbl;
    private javax.swing.JButton langBtn;
    private javax.swing.JButton skinnyPityBtn;
    private javax.swing.JLabel skinnyPityImg;
    // End of variables declaration//GEN-END:variables
}
