package com.expressswallows.model.restaurant.users;

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
