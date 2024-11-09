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
public abstract class Person {
 
    protected String firstName;
    protected String lastName;
    protected static String email;
    protected static String password;
    protected Date dob;
    protected String phoneNumber;

    public Person(String firstName, String lastName, String email, String password, Date dob, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    public Date getDob() {
        return dob;
    }
    
    public abstract boolean validateAge(Date date);
    
 
}
