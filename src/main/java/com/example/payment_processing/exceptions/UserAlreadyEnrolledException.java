package com.example.payment_processing.exceptions;


public class UserAlreadyEnrolledException extends RuntimeException {
    public UserAlreadyEnrolledException(String message) {super(message);}
}
