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
    private static double cashBalance = 0.0;
    private static double creditBalance = 0.0;

    public static void makePayment(double amount, String method, double required) {
        double change = amount - required;
        if (method.equals("Cash")) {
            cashBalance += amount - change; //returns the exact amount
        } else if (method.equals("Credit")) {
            creditBalance += amount - change; //returns the exact amount
        }
        
    }

    public static double getCashBalance() {
        return cashBalance;
    }

    public static double getCreditBalance() {
        return creditBalance;
    }
    
}
