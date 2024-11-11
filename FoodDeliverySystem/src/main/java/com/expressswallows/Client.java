/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows;

import java.util.Date;

/**
 *
 * @author shahi
 */
public class Client extends Person{

    private static int count = 1;
    private int clientId;
    private Address address;

    public Client(String firstName, String lastName, String email, String password, Date dob, String phoneNumber, Address address) {
        super(firstName, lastName, email, password, dob, phoneNumber);
        this.clientId = count++;
        this.address = address;
    }

    public boolean validateAge(Date date) {
        return false; 
    }
    
}
