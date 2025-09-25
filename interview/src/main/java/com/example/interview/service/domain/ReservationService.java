package com.example.interview.service.domain;

import com.example.interview.exceptions.BookNotFoundException;
import com.example.interview.exceptions.BookOutOfStockException;
import com.example.interview.exceptions.ReservationNotFoundException;
import com.example.interview.exceptions.UserNotFoundException;
import com.example.interview.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation reserveBook(String userEmail, String isbn);
    void returnBook(Long reservationId);

    List<Reservation> listReservations(String userEmail, String isbn);
}
