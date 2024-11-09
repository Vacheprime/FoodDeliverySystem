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
public class Employee extends Person{
    private static int count = 1;
    private int employeeId;

    public Employee(String firstName, String lastName, String email, String password, Date dob, String phoneNumber) {
        super(firstName, lastName, email, password, dob, phoneNumber);
        this.employeeId = count++;
    }
    
    public boolean validateAge(Date date){
        return false;
    }
    
    
}
