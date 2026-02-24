package com.booking.commons.exception;

/**
 * Exception thrown when the client ID from the request does not match
 * the client ID associated with the resource in the database.
 * Results in a 403 Forbidden response.
 */
public class ClientIdMismatchException extends RuntimeException {

    public ClientIdMismatchException(String message) {
        super(message);
    }

    public ClientIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}