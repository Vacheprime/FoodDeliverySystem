/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.exceptions;

/**
 * DatabaseConnectionException is used to indicate errors during the connection
 * process of the DatabaseConnectionUtils class.
 * @author Danat
 */
public class DatabaseConnectionException extends DatabaseException {
    
    public DatabaseConnectionException(String message) {
        super(message);
    }
}
