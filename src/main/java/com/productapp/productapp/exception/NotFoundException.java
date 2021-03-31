package com.productapp.productapp.exception;


public class NotFoundException extends RuntimeException {

    private String message;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super();
    }
}
