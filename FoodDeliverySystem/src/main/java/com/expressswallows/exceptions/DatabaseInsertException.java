package com.expressswallows.exceptions;

/**
 * DatabaseInsertException is used to represent errors that occur during database insert operations.
 */
public class DatabaseInsertException extends DatabaseException {
    public DatabaseInsertException(String message) {
        super(message);
    }
}
