package com.example.interview.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("The requested user doesn't exist");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
