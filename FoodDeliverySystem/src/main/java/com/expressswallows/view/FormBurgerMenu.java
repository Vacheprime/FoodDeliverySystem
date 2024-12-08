/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.menu.factories.BurgerFactory;
import com.expressswallows.model.menu.factories.FoodFactoryCreator;
import com.expressswallows.model.menu.fooditems.burgers.Burger;
import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.utils.Utils;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 *
 * @author shahi
 */
public class FormBurgerMenu extends javax.swing.JFrame {

    Client client;
    Order order;
    ImageIcon bigFatty = new ImageIcon("..\\FoodDeliverySystem\\src\\main\\resources\\images\\bigfatty.jpg");
    ImageIcon greenBush = new ImageIcon("..\\FoodDeliverySystem\\src\\main\\resources\\images\\greenbush.jpg");
    ImageIcon skinnyPity = new ImageIcon("..\\FoodDeliverySystem\\src\\main\\resources\\images\\skinnypity.jpg");
    private final double PRICEBF = 14.99;
    private final double PRICEGB = 19.99;
    private final double PRICESP = 7.99;

    
    
    
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
        priceBFLbl = new javax.swing.JLabel();
        priceGBLbl = new javax.swing.JLabel();
        priceSPLbl = new javax.swing.JLabel();

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

        priceBFLbl.setText("Price:");

        priceGBLbl.setText("Price:");

        priceSPLbl.setText("Price:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(bigFattyLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bigFattyImg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bigFattyBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceBFLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(burgerMenuLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(langBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(greenBushLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(greenBushImg, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(greenBushBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(priceGBLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(126, 126, 126))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(bigFattyLbl1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(skinnyPityImg, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(skinnyPityBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(priceSPLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceBFLbl)
                    .addComponent(priceGBLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bigFattyBtn)
                    .addComponent(greenBushBtn))
                .addGap(4, 4, 4)
                .addComponent(bigFattyLbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skinnyPityImg, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(priceSPLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skinnyPityBtn)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update(){
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        backBtn.setText(rb.getString("back"));
        burgerMenuLbl.setText(rb.getString("burgermenu"));
        langBtn.setText(rb.getString("lang"));
        bigFattyBtn.setText(rb.getString("addtocart"));
        greenBushBtn.setText(rb.getString("addtocart"));
        skinnyPityBtn.setText(rb.getString("addtocart"));

        if (Utils.currentLocale.getLanguage().equals("en")) {
            priceBFLbl.setText(rb.getString("price") + "$" + PRICEBF);
            priceGBLbl.setText(rb.getString("price") + "$" + PRICEGB);
            priceSPLbl.setText(rb.getString("price") + "$" + PRICESP);
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            priceBFLbl.setText(rb.getString("price") + PRICEBF + "$");
            priceGBLbl.setText(rb.getString("price") + PRICEGB + "$");
            priceSPLbl.setText(rb.getString("price") + PRICESP + "$");
        }

    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        new FormClientMainMenu(client, order).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void langBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langBtnActionPerformed
        Utils.switchLanguage();
        update();
    }//GEN-LAST:event_langBtnActionPerformed

    private void bigFattyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bigFattyBtnActionPerformed
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String choice = "BigFatty";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        BurgerFactory factory = (BurgerFactory) creator.getFoodFactory("Burger");
        Burger burger = factory.createBurger(choice);
        order.addFoodToOrder(burger);
        String message = rb.getString("bigfattymessage");
        String title = rb.getString("burgerTitle");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bigFattyBtnActionPerformed

    private void greenBushBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenBushBtnActionPerformed
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String choice = "GreenBush";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        BurgerFactory factory = (BurgerFactory) creator.getFoodFactory("Burger");
        Burger burger = factory.createBurger(choice);
        order.addFoodToOrder(burger);
        String message = rb.getString("greenbushmes");
        String title = rb.getString("burgerTitle");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_greenBushBtnActionPerformed

    private void skinnyPityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinnyPityBtnActionPerformed
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String choice = "SkinnyPity";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        BurgerFactory factory = (BurgerFactory) creator.getFoodFactory("Burger");
        Burger burger = factory.createBurger(choice);
        order.addFoodToOrder(burger);
        String message = rb.getString("skinnypitymes");
        String title = rb.getString("burgerTitle");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JLabel priceBFLbl;
    private javax.swing.JLabel priceGBLbl;
    private javax.swing.JLabel priceSPLbl;
    private javax.swing.JButton skinnyPityBtn;
    private javax.swing.JLabel skinnyPityImg;
    // End of variables declaration//GEN-END:variables
}
