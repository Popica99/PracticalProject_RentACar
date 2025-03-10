package org.example.Exceptions;

public class InvalidClientException extends RuntimeException {
    public InvalidClientException(String message) {
        super(message);
    }
}
