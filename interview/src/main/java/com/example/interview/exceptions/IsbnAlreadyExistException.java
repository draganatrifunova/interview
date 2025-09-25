package com.example.interview.exceptions;

public class IsbnAlreadyExistException extends RuntimeException{
    public IsbnAlreadyExistException() {
        super("This isbn already exist. Choose another one!");
    }

    public IsbnAlreadyExistException(String message) {
        super(message);
    }
}
