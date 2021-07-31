package com.raphael.medium.customer.controller.exception;

public class CustomerSystemException extends RuntimeException {
    public CustomerSystemException(String message) {
        super(message);
    }

    public CustomerSystemException(String message, Exception e) {
        super(message, e);
    }
}
