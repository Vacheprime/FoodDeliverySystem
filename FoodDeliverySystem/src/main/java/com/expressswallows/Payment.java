/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows;

/**
 *
 * @author shahi
 */
public class Payment {
    Client client;
    private static double creditBalance = 0.0;

    public static void makePayment(double amount, String method) {
        if (method.equals("Credit")) {
            creditBalance += amount; //returns the exact amount
        }
        
    }

    public static double getCreditBalance() {
        return creditBalance;
    }
    
}
