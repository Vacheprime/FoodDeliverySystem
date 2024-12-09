/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.exceptions;

/**
 * DatabaseException is used to indicate general database errors that occur 
 * during database operations.
 * 
 * @author Danat
 */
public class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super(message);
    }
}
