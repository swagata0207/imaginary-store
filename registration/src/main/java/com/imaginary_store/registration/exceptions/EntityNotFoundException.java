package com.imaginary_store.registration.exceptions;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
