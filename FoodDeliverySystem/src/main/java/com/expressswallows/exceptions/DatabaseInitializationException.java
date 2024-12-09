/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.exceptions;

/**
 * DatabaseInitializationException is used to indicate errors during the 
 * initialization (creation) process of the database.
 * 
 * @author Danat
 */
public class DatabaseInitializationException extends DatabaseException {
    
    public DatabaseInitializationException(String message) {
        super(message);
    }
}
