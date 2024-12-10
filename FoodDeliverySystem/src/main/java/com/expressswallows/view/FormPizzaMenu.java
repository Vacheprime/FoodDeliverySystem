/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.controller.PizzaMenuController;
import com.expressswallows.model.menu.factories.FoodFactoryCreator;
import com.expressswallows.model.menu.factories.HotdogFactory;
import com.expressswallows.model.menu.factories.PizzaFactory;
import com.expressswallows.model.menu.fooditems.hotdogs.Hotdog;
import com.expressswallows.model.menu.fooditems.pizzas.Pizza;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.Order;
import com.expressswallows.utils.Utils;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 *
 * @author shahi
 */
public class FormPizzaMenu extends javax.swing.JFrame {

    public PizzaMenuController controller;
    public Client client;
    public Order order;
    ImageIcon cheeseImg = new ImageIcon("..\\FoodDeliverySystem\\src\\main\\resources\\images\\cheese.jpg");
    ImageIcon pepperoniImg = new ImageIcon("..\\FoodDeliverySystem\\src\\main\\resources\\images\\pepperoni.jpg");
    ImageIcon alldressImg = new ImageIcon("..\\FoodDeliverySystem\\src\\main\\resources\\images\\alldress.jpg");
    public final double PRICECHEEESE = 10.99;
    public final double PRICEPEP = 17.99;
    public final double PRICEAD = 22.99;

    /**
     * Creates new form frmPizzaMenu
     */
    public FormPizzaMenu(Client client, Order order) {
        initComponents();
        this.client = client;
        this.order = order;
        this.controller = new PizzaMenuController(this);
        cheeseLblImg.setText("");
        cheeseLblImg.setIcon(cheeseImg);
        pepperoniLblImg.setText("");
        pepperoniLblImg.setIcon(pepperoniImg);
        alldressLblImg.setText("");
        alldressLblImg.setIcon(alldressImg);
        controller.updateLanguage();
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

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        controller.backButtonClicked();
    }//GEN-LAST:event_backBtnActionPerformed

    private void langBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langBtnActionPerformed
        Utils.switchLanguage();
        controller.updateLanguage();

    }//GEN-LAST:event_langBtnActionPerformed

    private void cheeseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheeseBtnActionPerformed
        controller.cheesePizza();
    }//GEN-LAST:event_cheeseBtnActionPerformed

    private void pepperoniBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pepperoniBtnActionPerformed
        controller.pepperoniPizza();
    }//GEN-LAST:event_pepperoniBtnActionPerformed

    private void alldressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alldressBtnActionPerformed
        controller.allDressedPizza();
    }//GEN-LAST:event_alldressBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton alldressBtn;
    public javax.swing.JLabel alldressLbl;
    public javax.swing.JLabel alldressLblImg;
    public javax.swing.JButton backBtn;
    public javax.swing.JButton cheeseBtn;
    public javax.swing.JLabel cheeseLbl;
    public javax.swing.JLabel cheeseLblImg;
    public javax.swing.JButton langBtn;
    public javax.swing.JButton pepperoniBtn;
    public javax.swing.JLabel pepperoniLbl;
    public javax.swing.JLabel pepperoniLblImg;
    public javax.swing.JLabel pizzaMenuLbl;
    public javax.swing.JLabel priceADLbl;
    public javax.swing.JLabel priceCheeseLbl;
    public javax.swing.JLabel pricePepLbl;
    // End of variables declaration//GEN-END:variables
}
