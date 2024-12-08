package com.expressswallows.model.restaurant.users;

import com.expressswallows.utils.Utils;
import java.time.LocalDate;

/**
 * Client class represents a client.
 * @author shahi
 */
public class Client extends Person{
    private int clientId;
    private Address address;

    /**
     * All argument constructor for a new Client object.
     * 
     * @param firstName the first name of the client.
     * @param lastName the last name of the client.
     * @param email the email address of the client.
     * @param password the password of the client.
     * @param dob the date of birth of the client.
     * @param phoneNumber the phoneNumber of the client.
     * @param address the address of the client.
     */
    public Client(String firstName, String lastName, String email, String password, LocalDate dob, String phoneNumber, Address address) {
        super(firstName, lastName, email, password, dob, phoneNumber);
        // Make sure the address is not null
        if (address == null) {
            throw new IllegalArgumentException("The address cannot be null.");
        }
        // Validate age
        if (!Utils.validateClientAge(dob)) {
            throw new IllegalArgumentException("The client must be at least 16 years of age.");
        }
        this.clientId = -1;
        this.address = address;
    }

    /**
     * Getter for the ID.
     * @return the ID of the client.
     */
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Getter for the address.
     * @return the address of the client.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * The setter for the address.
     * @param address the new address.
     */
    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("The address cannot be null.");
        }
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.clientId;
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
        final Client other = (Client) obj;
        return this.clientId == other.clientId;
    }

    @Override
    public String toString() {
        return String.format("Client{ID: %d, FirstName: %s, LastName: %s, "
                + "Email: %s, Dob: %s, Phone: %s}", clientId, getFirstName(), 
                getLastName(), getEmail(), getDob(), getPhoneNumber());
    }
}