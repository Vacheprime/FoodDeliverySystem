package com.expressswallows;

import com.expressswallows.utils.Utils;
import java.time.LocalDate;

/**
 * Person abstract class represents a user of the application, whether client
 * or employee. 
 * @author shahi
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private final LocalDate dob;
    private String phoneNumber;
    
    /**
     * All argument constructor for a new Person object.
     * 
     * @param firstName the first name of the person.
     * @param lastName the last name of the person.
     * @param email the email address of the person.
     * @param password the password of the person.
     * @param dob the date of birth of the person.
     * @param phoneNumber the phone number of the person.
     */
    public Person(String firstName, String lastName, String email, String password, LocalDate dob, String phoneNumber) {
        // Make sure no argument is null
        if (firstName == null || this.lastName == null || email == null || 
                password == null || dob == null || phoneNumber == null) {
            throw new IllegalArgumentException("The person's personal information cannot be null.");
        }
        // Validate the provided email address
        if (!Utils.validateEmailAddress(email)) {
            throw new IllegalArgumentException("The email address's format is invalid.");
        }
        // Validate the provided phone number
        if (!Utils.validatePhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("The phone number's format is invalid.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for the date of birth.
     * @return the date of birth of the person.
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Getter for the first name.
     * @return the first name of the person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for the last name.
     * @return the last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for the email address.
     * @return the email address of the person.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the email address.
     * @param email the new email address.
     */
    public void setEmail(String email) {
        if (!Utils.validateEmailAddress(email)) {
            throw new IllegalArgumentException("The email address's format is invalid.");
        }
        this.email = email;
    }

    /**
     * Getter for the password.
     * @return the password of the person.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the password.
     * @param password the new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for the phone number.
     * @return the phone number of the person.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for the phone number.
     * @param phoneNumber the new phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        if (!Utils.validatePhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("The phone number's format is invalid.");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 43 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 43 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 43 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 43 * hash + (this.dob != null ? this.dob.hashCode() : 0);
        hash = 43 * hash + (this.phoneNumber != null ? this.phoneNumber.hashCode() : 0);
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
        final Person other = (Person) obj;
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if ((this.phoneNumber == null) ? (other.phoneNumber != null) : !this.phoneNumber.equals(other.phoneNumber)) {
            return false;
        }
        return this.dob == other.dob || (this.dob != null && this.dob.equals(other.dob));
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName +
                ", email=" + email + ", password=" + password + ", dob=" + dob +
                ", phoneNumber=" + phoneNumber + '}';
    }
}