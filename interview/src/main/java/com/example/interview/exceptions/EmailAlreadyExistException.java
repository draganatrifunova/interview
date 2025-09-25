package com.example.interview.exceptions;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException() {
        super("This email already exist. Choose another one!");
    }

    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
