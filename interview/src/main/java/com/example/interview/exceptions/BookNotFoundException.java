package com.example.interview.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super("The requested book doesn't exist");
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
