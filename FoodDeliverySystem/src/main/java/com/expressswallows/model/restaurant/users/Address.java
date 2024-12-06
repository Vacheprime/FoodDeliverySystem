package com.expressswallows.model.restaurant.users;

import com.expressswallows.utils.Utils;

/**
 * Address class is used to represent the address and shipping address of clients.
 * It is used to compute the 2D coordinates of the client used in shipping.
 * 
 * @author shahi
 */
public class Address {
    private final String street;
    private final String postalCode;
    private final String streetNo;
    private final City city;
    
    /**
     * Enum City is used to represent all possible values that the city 
     * field can take. Only Montreal is available for this application.
     */
    public enum City {
        Montreal
    }

    /**
     * All argument constructor for an Address object.
     * 
     * @param street the street.
     * @param streetNo the street number.
     * @param postalCode the postal code.
     * @param city the city.
     */
    public Address(String street, String streetNo, String postalCode, City city) {
        // Check if the arguments are null
        if (street == null || streetNo == null ||
                postalCode == null || city == null) {
            throw new IllegalArgumentException("The address information cannot be null.");
        }
        if (!Utils.validatePostalCode(postalCode)) {
            throw new IllegalArgumentException("The postal code provided is invalid.");
        }
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.streetNo = streetNo;
    }

    /**
     * Getter for the street.
     * @return the street of the address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Getter for the postal code.
     * @return the postal code of the address.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Getter for the street number.
     * @return the street number of the address.
     */
    public String getStreetNo() {
        return streetNo;
    }

    /**
     * Getter for the city.
     * @return the city of the address.
     */
    public City getCity() {
        return city;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.street != null ? this.street.hashCode() : 0);
        hash = 37 * hash + (this.postalCode != null ? this.postalCode.hashCode() : 0);
        hash = 37 * hash + (this.streetNo != null ? this.streetNo.hashCode() : 0);
        hash = 37 * hash + (this.city != null ? this.city.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if ((this.street == null) ? (other.street != null) : !this.street.equals(other.street)) {
            return false;
        }
        if ((this.postalCode == null) ? (other.postalCode != null) : !this.postalCode.equals(other.postalCode)) {
            return false;
        }
        if ((this.streetNo == null) ? (other.streetNo != null) : !this.streetNo.equals(other.streetNo)) {
            return false;
        }
        return this.city == other.city;
    }
    
    /**
     * Map the current address to an X coordinate.
     * This method takes the hashcode of the streetNo, squares it, and
     * uses the remainder operator to bring it to a value between 0 and 249.
     * 
     * @return an X coordinate corresponding to this address.
     */
    public int mapAddressToX() {
        // Simulate a hashing function
        return (int) (Math.pow(streetNo.hashCode(), 2) % 250);
    }
    
    /**
     * Map the current address to a Y coordinate.
     * This method takes the hashcode of the street, squares it, and uses
     * the remainder operator to bring it to a value between 0 and 249.
     * 
     * @return an Y coordinate corresponding to this address.
     */
    public int mapAddressToY() {
        // Simulate a hashing function
        return (int) (Math.pow(street.hashCode(), 2) % 250);
    }

    @Override
    public String toString() {
        return streetNo + " " + street + ", " + postalCode + ", " + city;
    }
}