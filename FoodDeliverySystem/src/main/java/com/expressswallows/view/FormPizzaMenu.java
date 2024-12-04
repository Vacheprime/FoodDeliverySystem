/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.Order;
import com.expressswallows.utils.Utils;

import javax.swing.ImageIcon;
import java.util.ResourceBundle;

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
        update();
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
        priceCheeseLbl = new javax.swing.JLabel();
        pricePepLbl = new javax.swing.JLabel();
        priceADLbl = new javax.swing.JLabel();

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

        priceCheeseLbl.setText("Price:");

        pricePepLbl.setText("Price:");

        priceADLbl.setText("Price:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(priceCheeseLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cheeseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(293, 293, 293)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pepperoniBtn)
                    .addComponent(pricePepLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(cheeseLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(pepperoniLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(cheeseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pepperoniLbl)
                        .addGap(106, 106, 106)))
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(pizzaMenuLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(langBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(alldressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(alldressLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(priceADLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alldressBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(pizzaMenuLbl)
                    .addComponent(langBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cheeseLbl)
                    .addComponent(pepperoniLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cheeseLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pepperoniLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceCheeseLbl)
                    .addComponent(pricePepLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cheeseBtn)
                    .addComponent(pepperoniBtn))
                .addGap(18, 18, 18)
                .addComponent(alldressLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alldressLblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceADLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alldressBtn)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        backBtn.setText(rb.getString("back"));
        langBtn.setText(rb.getString("lang"));
        pizzaMenuLbl.setText(rb.getString("pizzamenu"));
        cheeseLbl.setText(rb.getString("cheese"));
        alldressLbl.setText(rb.getString("alldress"));
        alldressBtn.setText(rb.getString("addtocart"));
        pepperoniBtn.setText(rb.getString("addtocart"));
        cheeseBtn.setText(rb.getString("addtocart"));
        priceADLbl.setText(rb.getString("price"));
        priceCheeseLbl.setText(rb.getString("price"));
        pricePepLbl.setText(rb.getString("price"));
    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        new FormClientMainMenu(client, order).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void langBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langBtnActionPerformed
        Utils.switchLanguage();
        update();

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
    private javax.swing.JLabel priceADLbl;
    private javax.swing.JLabel priceCheeseLbl;
    private javax.swing.JLabel pricePepLbl;
    // End of variables declaration//GEN-END:variables
}
