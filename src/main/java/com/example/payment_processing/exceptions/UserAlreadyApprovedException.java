package com.example.payment_processing.exceptions;


public class UserAlreadyApprovedException extends RuntimeException {
    public UserAlreadyApprovedException(String message) {super(message);}
}