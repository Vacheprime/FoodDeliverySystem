/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.utils.Utils;
import java.util.ArrayList;

import java.util.List;
import java.util.ResourceBundle;
import javax.swing.DefaultListModel;

/**
 *
 * @author shahi
 */
public class FormViewCart extends javax.swing.JFrame {

    Order order;
    Client client;
    List<Food> foods = order.getFoods();

    /**
     * Creates new form FormViewCart
     */
    public FormViewCart(Client client, Order order) {
        initComponents();
        this.order = order;
        this.client = client;
        update();
        loadOrder(order.getFoods());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewcartLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        payBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOrders = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewcartLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        viewcartLbl.setText("Your Cart");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        payBtn.setText("Pay");
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listOrders);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(backBtn)
                .addGap(18, 18, 18)
                .addComponent(payBtn)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(viewcartLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewcartLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(payBtn))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        viewcartLbl.setText(rb.getString("yourcart"));
        payBtn.setText(rb.getString("pay"));
        backBtn.setText(rb.getString("back"));
    }

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        dispose();
        new FormPayment(client, order).setVisible(true);
    }//GEN-LAST:event_payBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        dispose();
        new FormClientMainMenu(client, order).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void loadOrder(List<Food> foods) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Food food : foods) {
            listModel.addElement(food.toString());
        }
        listOrders.setModel(listModel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listOrders;
    private javax.swing.JButton payBtn;
    private javax.swing.JLabel viewcartLbl;
    // End of variables declaration//GEN-END:variables
}
