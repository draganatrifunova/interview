package com.example.interview.web;


import com.example.interview.dto.DisplayReservationDto;
import com.example.interview.exceptions.BookNotFoundException;
import com.example.interview.exceptions.BookOutOfStockException;
import com.example.interview.exceptions.ReservationNotFoundException;
import com.example.interview.exceptions.UserNotFoundException;
import com.example.interview.model.Reservation;
import com.example.interview.service.application.ReservationApplicationService;
import com.example.interview.service.domain.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"", "/reservations"})
public class ReservationController {
    private final ReservationApplicationService reservationApplicationService;

    public ReservationController(ReservationApplicationService reservationApplicationService) {
        this.reservationApplicationService = reservationApplicationService;
    }

    @PostMapping("/reserve")
    public ResponseEntity<DisplayReservationDto> reserveBook(@RequestParam String userEmail,
                                                      @RequestParam String isbn){
        return ResponseEntity.ok(this.reservationApplicationService
                .reserveBook(userEmail, isbn));
    }

    @PostMapping("/return/{reservationId}")
    public ResponseEntity<Void> returnBook(@PathVariable Long reservationId){
        this.reservationApplicationService
                .returnBook(reservationId);

        return ResponseEntity
                .noContent().build();
    }


    @GetMapping("/list")
    public ResponseEntity<List<DisplayReservationDto>> listReservations(@RequestParam(required = false) String userEmail,
                                                                        @RequestParam(required = false) String isbn){
        return ResponseEntity.ok(this.reservationApplicationService
                .listReservations(userEmail, isbn));

    }

}
