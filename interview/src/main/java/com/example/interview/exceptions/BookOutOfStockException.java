package com.example.interview.exceptions;

public class BookOutOfStockException extends RuntimeException {

    public BookOutOfStockException() {
        super("The requested book is out of stock");
    }

    public BookOutOfStockException(String message) {
        super(message);
    }
}

