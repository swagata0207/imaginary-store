package com.imaginary_store.registration.exceptions;

public class EmptyRequestBodyException extends Exception {

    public EmptyRequestBodyException() {
        super("Empty RequestBody");
    }

    public EmptyRequestBodyException(String message) {
        super(message);
    }
}
