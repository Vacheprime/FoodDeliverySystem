package com.expressswallows.model.restaurant.users;

import com.expressswallows.utils.Utils;
import java.time.LocalDate;

/**
 * Employee class used to represent an employee.
 * @author shahi
 */
public class Employee extends Person{
    private int employeeId;

    /**
     * All argument constructor for an Employee object.
     * 
     * @param firstName the first name of the employee.
     * @param lastName the last name of the employee.
     * @param email the email of the employee.
     * @param password the password of the employee.
     * @param dob the date of birth of the employee.
     * @param phoneNumber the phone number of the employee.
     */
    public Employee(String firstName, String lastName, String email, String password, LocalDate dob, String phoneNumber) {
        super(firstName, lastName, email, password, dob, phoneNumber);
        // Validate the age of the employee
        if (!Utils.validateEmployeeAge(dob)) {
            throw new IllegalArgumentException("The employee must be at least 18 years of age.");
        }
        this.employeeId = -1;
    }

    /**
     * Getter for the employee ID.
     * @return the employee ID.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.employeeId;
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
        final Employee other = (Employee) obj;
        return this.employeeId == other.employeeId;
    }

    @Override
    public String toString() {
        return String.format("Employee{ID: %d, FirstName: %s, LastName: %s, "
                + "Email: %s, Dob: %s, Phone: %s}", employeeId, getFirstName(), 
                getLastName(), getEmail(), getDob(), getPhoneNumber());
    }    
}