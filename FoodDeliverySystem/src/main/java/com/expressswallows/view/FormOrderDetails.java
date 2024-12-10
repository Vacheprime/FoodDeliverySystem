/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.Main;
import com.expressswallows.controller.RestaurantController;
import com.expressswallows.exceptions.DatabaseException;
import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.Payment;
import com.expressswallows.model.restaurant.Restaurant;
import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.utils.DatabaseConnectionUtils;
import com.expressswallows.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author shahi
 */
public class FormOrderDetails extends javax.swing.JFrame {

    Client client;
    Order order;
    Restaurant restaurant;
    Payment payment;
    Restaurant.OrderProcessTask task;
    //List of restaurants from the database
    /**
     * Creates new form FormOrderDetails
     */
    
    public FormOrderDetails(Client client, Order order, Payment payment) {
        initComponents();
        this.client = client;
        this.order = order;
        this.payment = payment;
        orderListTA.setText(foodList(order));
        try(var data = DatabaseConnectionUtils.getInstance()) {
            restaurant = RestaurantController.findRestaurant(order, data.fetchRestaurantLocations());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            restaurant.addOrder(order);
            order.setRestaurantId(restaurant.getRestaurantId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try(var database = DatabaseConnectionUtils.getInstance()) {
            database.insertOrder(order);
            database.insertPayment(payment, restaurant.getRestaurantId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        update();

    }
    
    public FormOrderDetails(Client client, Order order) {
        initComponents();
        this.client = client;
        this.order = order;

        try (var database = DatabaseConnectionUtils.getInstance()) {
            this.restaurant = database.fetchRestaurantLocations().stream().filter(r -> r.getRestaurantId() == order.getRestaurantId()).findFirst().get();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        orderListTA.setText(foodList(order));


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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        backBtn = new javax.swing.JButton();
        orderLbl = new javax.swing.JLabel();
        locationAssignedLbl = new javax.swing.JLabel();
        statusLbl = new javax.swing.JLabel();
        etaLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderListTA = new javax.swing.JTextArea();
        langBtn = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        orderLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        orderLbl.setText("Order#");

        locationAssignedLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        locationAssignedLbl.setText("Location assigned:");

        statusLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusLbl.setText("Status:");

        etaLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etaLbl.setText("Estimate time of arrival:");

        orderListTA.setEditable(false);
        orderListTA.setColumns(20);
        orderListTA.setRows(5);
        jScrollPane2.setViewportView(orderListTA);

        langBtn.setText("French");
        langBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(orderLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(langBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(locationAssignedLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                .addComponent(statusLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(orderLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(langBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(locationAssignedLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(etaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        langBtn.setText(rb.getString("lang"));
        backBtn.setText(rb.getString("back"));

        if (Utils.currentLocale.getLanguage().equals("en")) {
            orderLbl.setText(rb.getString("order") + order.getOrderId());
            etaLbl.setText(rb.getString("eta") + RestaurantController.getTotalTime(order,restaurant));
            locationAssignedLbl.setText(rb.getString("locationassigned") + restaurant.toString());
            statusLbl.setText(rb.getString("status") + order.getStatus());
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            orderLbl.setText(rb.getString("order") + order.getOrderId());
            etaLbl.setText(rb.getString("eta") + RestaurantController.getTotalTime(order,restaurant));
            locationAssignedLbl.setText(rb.getString("locationassigned") + restaurant.toString());
            statusLbl.setText(rb.getString("status") + order.getStatus());
        }

    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Order newOrder = new Order(client);
        this.dispose();
        new FormClientMainMenu(client, newOrder).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void langBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langBtnActionPerformed
        Utils.switchLanguage();
        update();
    }//GEN-LAST:event_langBtnActionPerformed

    private String foodList(Order order) {
        StringBuilder foodDetails = new StringBuilder();
    
        for (Food food : order.getFoods()) {
            foodDetails.append(food.toString()).append("\n");           
        }
        return foodDetails.toString();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel etaLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton langBtn;
    private javax.swing.JLabel locationAssignedLbl;
    private javax.swing.JLabel orderLbl;
    private javax.swing.JTextArea orderListTA;
    private javax.swing.JLabel statusLbl;
    // End of variables declaration//GEN-END:variables
}
