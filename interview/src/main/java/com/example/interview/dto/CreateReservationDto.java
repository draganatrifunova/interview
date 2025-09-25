package com.example.interview.dto;

import com.example.interview.model.Book;
import com.example.interview.model.Reservation;
import com.example.interview.model.User;

//    public Reservation(Book book, User user) {
public record CreateReservationDto(String isbn, Long userId) {
    public Reservation toReservation(Book book, User user){
        return new Reservation(book, user);
    }
}
