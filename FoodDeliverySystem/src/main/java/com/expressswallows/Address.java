/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows;

/**
 *
 * @author shahi
 */
public class Address {
    private String street;
    private String postalCode;
    private enum city {
        Montreal
    }

    public Address(String street, int streetNo, String postalCode) {
        this.street = street;
        this.postalCode = postalCode;
    }
    
    public boolean validateZipcode(String zip){
        return false;
    }
    
    
    
    
}
