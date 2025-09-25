package com.example.interview.service.application;

import com.example.interview.dto.DisplayReservationDto;
import com.example.interview.exceptions.BookNotFoundException;
import com.example.interview.exceptions.BookOutOfStockException;
import com.example.interview.exceptions.ReservationNotFoundException;
import com.example.interview.exceptions.UserNotFoundException;

import java.util.List;

public interface ReservationApplicationService {

    DisplayReservationDto reserveBook(String userEmail, String isbn);

    void returnBook(Long reservationId);

    List<DisplayReservationDto> listReservations(String userEmail, String isbn);
}
