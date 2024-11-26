package com.imaginary_store.registration.exceptions;

public class DuplicateEntityException extends Exception {

    public DuplicateEntityException() {
        super();
    }

    public DuplicateEntityException(String message) {
        super(message);
    }
}
