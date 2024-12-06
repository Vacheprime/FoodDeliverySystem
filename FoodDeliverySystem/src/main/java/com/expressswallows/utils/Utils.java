package com.expressswallows.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Utils class used to contain static functions that could be used in many
 * classes throughout the application.
 * 
 * @author Danat
 */
public class Utils {

    public static final Locale cultureEn = new Locale("en", "CA");
    public static final Locale cultureFr = new Locale("fr", "CA");
    public static Locale currentLocale = cultureEn;

    /**
     * Determine whether a zip code follows the following format:
     * A1A B2B
     * The method checks if the string matches the following regex:
     * ^[A-Z][0-9][A-Z] [0-9][A-Z][0-9]$
     * 
     * @param postalCode the postal code to validate.
     * @return a boolean indicating the validity of the postal code.
     */
    public static boolean validatePostalCode(String postalCode) {
        if (postalCode == null) {
            throw new IllegalArgumentException("The zip code cannot be null.");
        }
        return postalCode.matches("^[A-Z][0-9][A-Z] [0-9][A-Z][0-9]$");
    }
    
    /**
     * Determine whether a phone number follows the following format:
     * (123) 456-7890
     * The method checks if the string matches the following regex:
     * ^\(\d{3}\) \d{3}-\d{4}$
     * 
     * @param number the phone number to validate.
     * @return a boolean indicating the validity of the phone number.
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
        return email.matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~\\-]+@[a-zA-Z0-9\\-]+\\.[a-zA-Z0-9\\-]+$");
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
     * Determine whether a name is valid.
     * The name must start and end with a letter or period.
     * The name cannot contain numbers or special characters.
     * @param name the name to validate.
     * @return a boolean indicating the validity of the name.
     */
    public static boolean validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("The name cannot be null.");
        }
        return name.matches("^([\\p{L}.]+ ?)+(\\p{L}|\\.$)");
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
     * Determine whether a spiciness level is valid.
     * The spiciness level is in range of 0 to 10 inclusively.
     * @param spiciness the spiciness level to validate.
     * @return a boolean indicating whether the spiciness
     * level is valid.
     */
    public static boolean validateSpicinessLevel(int spiciness) {
        return spiciness >= 0 && spiciness <= 10;
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


    /**
     * Validates a date string to ensure it follows the format yyyy-MM-dd and converts it to a LocalDate to make sure they are not too old.
     * @param dob the date of birth as a string in the format yyyy-MM-dd.
     * @return true if the date string is valid and can be parsed into a LocalDate and false if the date string is in an invalid format or cannot be parsed.
     * @throws DateTimeParseException if the string cannot be parsed to a valid LocalDate.
     */
    public static boolean validateDate(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
        LocalDate parsedDate = LocalDate.parse(dob, formatter);
        if (parsedDate.getYear() < 1900) {
            return false;
        }
        return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Parses a date of birth string (yyyy-MM-dd) into a LocalDate
     * @param dob the date of birth as a string in the format yyyy-MM-dd.
     * @return the LocalDate or null if the format is invalid.
     */
    public static LocalDate parseDobToLocalDate(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(dob, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /***
     * Changes the currentLocale to the selected language of the users.
     */
    public static void switchLanguage() {
        if (currentLocale.equals(cultureEn)) {
            currentLocale = cultureFr;
        } else {
            currentLocale = cultureEn;
        }
    }

}