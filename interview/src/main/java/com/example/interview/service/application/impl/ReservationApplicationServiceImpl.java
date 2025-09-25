package com.example.interview.service.application.impl;

import com.example.interview.dto.DisplayReservationDto;
import com.example.interview.exceptions.BookNotFoundException;
import com.example.interview.exceptions.BookOutOfStockException;
import com.example.interview.exceptions.ReservationNotFoundException;
import com.example.interview.exceptions.UserNotFoundException;
import com.example.interview.service.application.ReservationApplicationService;
import com.example.interview.service.domain.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationApplicationServiceImpl implements ReservationApplicationService {

    private final ReservationService reservationService;

    public ReservationApplicationServiceImpl(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public DisplayReservationDto reserveBook(String userEmail, String isbn){
        return DisplayReservationDto.from(this.reservationService
                .reserveBook(userEmail, isbn));
    }

    @Override
    public void returnBook(Long reservationId){
        this.reservationService
                .returnBook(reservationId);
    }

    @Override
    public List<DisplayReservationDto> listReservations(String userEmail, String isbn) {
        return DisplayReservationDto.from(this.reservationService
                .listReservations(userEmail, isbn));
    }
}
