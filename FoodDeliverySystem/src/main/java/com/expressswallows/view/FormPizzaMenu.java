/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.Order;
import javax.swing.ImageIcon;

/**
 *
 * @author shahi
 */
public class FormPizzaMenu extends javax.swing.JFrame {

    Client client;
    Order order;
    ImageIcon cheeseImg = new ImageIcon("FoodDeliverySystem/cheese.jpg");
    ImageIcon pepperoniImg = new ImageIcon("FoodDeliverySystem/pepperoni.jpg");
    ImageIcon alldressImg = new ImageIcon("FoodDeliverySystem/alldress.jpg");
    /**
     * Creates new form frmPizzaMenu
     */
    public FormPizzaMenu(Client client, Order order) {
        initComponents();
        this.client = client;
        this.order = order;
        cheeseLblImg.setText("");
        cheeseLblImg.setIcon(cheeseImg);
        pepperoniLblImg.setText("");
        pepperoniLblImg.setIcon(pepperoniImg);
        alldressLblImg.setText("");
        alldressLblImg.setIcon(alldressImg);
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
        pizzaMenuLbl = new javax.swing.JLabel();
        cheeseLbl = new javax.swing.JLabel();
        cheeseLblImg = new javax.swing.JLabel();
        pepperoniLbl = new javax.swing.JLabel();
        pepperoniLblImg = new javax.swing.JLabel();
        alldressLbl = new javax.swing.JLabel();
        alldressLblImg = new javax.swing.JLabel();
        cheeseBtn = new javax.swing.JButton();
        pepperoniBtn = new javax.swing.JButton();
        alldressBtn = new javax.swing.JButton();

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

        pizzaMenuLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pizzaMenuLbl.setText("Pizza Menu");

        cheeseLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cheeseLbl.setText("Cheese");

        cheeseLblImg.setText("jLabel1");

        pepperoniLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pepperoniLbl.setText("Pepperoni");

        pepperoniLblImg.setText("jLabel3");

        alldressLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        alldressLbl.setText("All Dressed");

        alldressLblImg.setText("jLabel5");

        cheeseBtn.setText("Add to cart");
        cheeseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheeseBtnActionPerformed(evt);
            }
        });

        pepperoniBtn.setText("Add to cart");
        pepperoniBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pepperoniBtnActionPerformed(evt);
            }
        });

        alldressBtn.setText("Add to cart");
        alldressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alldressBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(cheeseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pepperoniBtn)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cheeseLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(pizzaMenuLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pepperoniLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(alldressBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alldressLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(alldressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(langBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(cheeseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pepperoniLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(langBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backBtn)
                        .addComponent(pizzaMenuLbl)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cheeseLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(pepperoniLblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cheeseLbl)
                            .addComponent(pepperoniLbl))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cheeseBtn)
                    .addComponent(pepperoniBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alldressLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alldressLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alldressBtn)
                .addContainerGap(120, Short.MAX_VALUE))
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

    private void cheeseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheeseBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cheeseBtnActionPerformed

    private void pepperoniBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pepperoniBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pepperoniBtnActionPerformed

    private void alldressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alldressBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alldressBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alldressBtn;
    private javax.swing.JLabel alldressLbl;
    private javax.swing.JLabel alldressLblImg;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cheeseBtn;
    private javax.swing.JLabel cheeseLbl;
    private javax.swing.JLabel cheeseLblImg;
    private javax.swing.JButton langBtn;
    private javax.swing.JButton pepperoniBtn;
    private javax.swing.JLabel pepperoniLbl;
    private javax.swing.JLabel pepperoniLblImg;
    private javax.swing.JLabel pizzaMenuLbl;
    // End of variables declaration//GEN-END:variables
}
