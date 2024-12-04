/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.users.Client;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author shahi
 */
public class FormClientMainMenu extends javax.swing.JFrame {
    Order order;
    Client client;
    ImageIcon burgerImage = new ImageIcon("FoodDeliverySystem/burger.jpg");
    ImageIcon pizzaImage = new ImageIcon("FoodDeliverySystem/pizza.jpg");
    ImageIcon hotdogImage = new ImageIcon("FoodDeliverySystem/hotdog.jpg");
    ImageIcon friesImage = new ImageIcon("FoodDeliverySystem/fries.jpg");
    ImageIcon drinksImage = new ImageIcon("FoodDeliverySystem/drinks.jpg");
    
    /**
     * Creates new form frmClientMainMenu
     */
    public FormClientMainMenu(Client client, Order order) {
        initComponents();
        this.client=client;
        this.order=order;
        burgerLbl.setText("");
        burgerLbl.setIcon(burgerImage);
        pizzaLbl.setText("");
        pizzaLbl.setIcon(pizzaImage);
        hotdogLbl.setText("");
        hotdogLbl.setIcon(hotdogImage);
        friesLbl.setText("");
        friesLbl.setIcon(friesImage);
        drinksLbl.setText("");
        drinksLbl.setIcon(drinksImage);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbl = new javax.swing.JLabel();
        langBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        burgerLbl = new javax.swing.JLabel();
        burgerBtn = new javax.swing.JButton();
        pizzaLbl = new javax.swing.JLabel();
        pizzaBtn = new javax.swing.JButton();
        hotdogLbl = new javax.swing.JLabel();
        hotdogBtn = new javax.swing.JButton();
        friesLbl = new javax.swing.JLabel();
        friesBtn = new javax.swing.JButton();
        drinksLbl = new javax.swing.JLabel();
        drinksBtn = new javax.swing.JButton();
        viewCartBtn = new javax.swing.JButton();
        viewPreOrderBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        titleLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLbl.setText("Express Swallows");

        langBtn.setText("French");
        langBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langBtnActionPerformed(evt);
            }
        });

        logoutBtn.setText("Log Out");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        burgerLbl.setText("jLabel1");

        burgerBtn.setText("Burger Menu");
        burgerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burgerBtnActionPerformed(evt);
            }
        });

        pizzaLbl.setText("jLabel1");

        pizzaBtn.setText("Pizza Menu");
        pizzaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaBtnActionPerformed(evt);
            }
        });

        hotdogLbl.setText("jLabel1");

        hotdogBtn.setText("Hotdog Menu");
        hotdogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotdogBtnActionPerformed(evt);
            }
        });

        friesLbl.setText("jLabel1");

        friesBtn.setText("Fries Menu");
        friesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friesBtnActionPerformed(evt);
            }
        });

        drinksLbl.setText("jLabel1");

        drinksBtn.setText("Drinks Menu");
        drinksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinksBtnActionPerformed(evt);
            }
        });

        viewCartBtn.setText("View Cart");
        viewCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCartBtnActionPerformed(evt);
            }
        });

        viewPreOrderBtn.setText("View Previous Orders");
        viewPreOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPreOrderBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(langBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(titleLbl)
                        .addGap(84, 84, 84)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(friesLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                .addComponent(burgerLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(burgerBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pizzaBtn)
                                .addGap(93, 93, 93))
                            .addComponent(hotdogLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(pizzaLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(drinksLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drinksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(friesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hotdogBtn)
                .addGap(175, 175, 175))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewPreOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLbl)
                    .addComponent(langBtn)
                    .addComponent(logoutBtn))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(burgerLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pizzaLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pizzaBtn)
                    .addComponent(burgerBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friesLbl)
                    .addComponent(hotdogLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friesBtn)
                    .addComponent(hotdogBtn))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(drinksLbl)
                    .addComponent(drinksBtn)
                    .addComponent(viewCartBtn))
                .addGap(18, 18, 18)
                .addComponent(viewPreOrderBtn)
                .addContainerGap(633, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you want to log out the application","Select",JOptionPane.YES_NO_OPTION);
        if(a == 0){
            this.dispose();
            new FormLogin().setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void burgerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_burgerBtnActionPerformed
        this.dispose();
        new FormBurgerMenu(client, order).setVisible(true);
    }//GEN-LAST:event_burgerBtnActionPerformed

    private void pizzaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pizzaBtnActionPerformed
        this.dispose();
        new FormPizzaMenu(client,order).setVisible(true);
    }//GEN-LAST:event_pizzaBtnActionPerformed

    private void hotdogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotdogBtnActionPerformed
        this.dispose();
        new FormHotDogMenu(client,order).setVisible(true);
    }//GEN-LAST:event_hotdogBtnActionPerformed

    private void friesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friesBtnActionPerformed
        this.dispose();
        new FormFriesMenu(client,order).setVisible(true);
    }//GEN-LAST:event_friesBtnActionPerformed

    private void drinksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinksBtnActionPerformed
        this.dispose();
        new FormDrinksMenu(client,order).setVisible(true);
    }//GEN-LAST:event_drinksBtnActionPerformed

    private void langBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_langBtnActionPerformed

    private void viewCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCartBtnActionPerformed
        this.dispose();
        new FormViewCart(client,order).setVisible(true);
    }//GEN-LAST:event_viewCartBtnActionPerformed

    private void viewPreOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPreOrderBtnActionPerformed
        this.dispose();
        new FormViewOrders(client, order).setVisible(true);
    }//GEN-LAST:event_viewPreOrderBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton burgerBtn;
    private javax.swing.JLabel burgerLbl;
    private javax.swing.JButton drinksBtn;
    private javax.swing.JLabel drinksLbl;
    private javax.swing.JButton friesBtn;
    private javax.swing.JLabel friesLbl;
    private javax.swing.JButton hotdogBtn;
    private javax.swing.JLabel hotdogLbl;
    private javax.swing.JButton langBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton pizzaBtn;
    private javax.swing.JLabel pizzaLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JButton viewCartBtn;
    private javax.swing.JButton viewPreOrderBtn;
    // End of variables declaration//GEN-END:variables
}
