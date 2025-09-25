package com.example.interview.exceptions;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException() {
        super("The requested reservation doesn't exist");
    }

    public ReservationNotFoundException(String message) {
        super(message);
    }
}
