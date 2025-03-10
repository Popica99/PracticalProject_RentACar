package org.example.Exceptions;

public class InvalidCarException extends RuntimeException {
    public InvalidCarException(String message) {
        super(message);
    }
}
