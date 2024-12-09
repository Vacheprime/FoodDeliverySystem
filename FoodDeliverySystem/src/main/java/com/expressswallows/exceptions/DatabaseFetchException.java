package com.expressswallows.exceptions;

/**
 * DatabaseFetchException is used to represent errors that occur when fetching data from the database.
 */
public class DatabaseFetchException extends DatabaseException {
    public DatabaseFetchException(String message) {
        super(message);
    }
}
