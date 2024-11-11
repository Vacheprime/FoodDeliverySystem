/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.utils;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Danat
 */
public class Utils {
    
    /**
     * Determine whether a phone number follows the following format:
     * (123) 456-7890
     * The method checks if the string matches the following regex:
     * ^\(\d{3}\) \d{3}-\d{4}$
     * 
     * @param number
     * @return 
     */
    public static boolean validatePhoneNumber(String number) {
        if (number == null) {
            throw new IllegalArgumentException("The phone number cannot be null.");
        }
        return number.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
    }
    
    /**
     * Determine whether an email address matches the email format.
     * Checks if the email matches the following regex:
     * ^[a-zA-Z0-9.!#$%&’*+\/=?^_`\{\|\}~\-]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-]+$
     * 
     * @param email the email to verify.
     * @return a boolean indicating whether the email's format it valid.
     */
    public static boolean validateEmailAddress(String email) {
        if (email == null) {
            throw new IllegalArgumentException("The email cannot be null.");
        }
        return email.matches("^[a-zA-Z0-9.!#$%&’*+\\/=?^_`\\{\\|\\}~\\-]+@[a-zA-Z0-9\\-]+\\.[a-zA-Z0-9\\-]+$");
    }
    
    /**
     * Determine whether a client is old enough to use the application.
     * @param dob the date of birth of the client.
     * @return a boolean indicating whether the client is old enough
     * to use the application.
     */
    public static boolean validateClientAge(LocalDate dob) {
        if (dob == null) {
            throw new IllegalArgumentException("The date of birth cannot be null.");
        }
        // Validate the age: must be at least 16 years of age
        return getDateDifferenceInYears(dob) >= 16;
    }
    
    /**
     * Determine whether an employee is old enough to be hired.
     * @param dob the date of birth of the employee.
     * @return a boolean indicating whether the employee is old enough to use
     * the application.
     */
    public static boolean validateEmployeeAge(LocalDate dob) {
        if (dob == null) {
            throw new IllegalArgumentException("The date of birth cannot be null.");
        }
        // Validate the age: must be at least 16 years of age
        return getDateDifferenceInYears(dob) >= 18;
    }
    
    /**
     * Calculate the difference in years between two LocalDates.
     * @param date The start date.
     * @return the difference between the start date and the current date in
     * years.
     */
    private static int getDateDifferenceInYears(LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears();
    }
}