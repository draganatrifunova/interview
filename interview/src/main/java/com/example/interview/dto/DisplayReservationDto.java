package com.example.interview.dto;

import com.example.interview.model.Reservation;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayReservationDto(Long id, String isbn, Long userId) {
    public static DisplayReservationDto from(Reservation reservation){
        return new DisplayReservationDto(reservation.getId(),
                reservation.getBook().getIsbn(),
                reservation.getUser().getId());
    }

    public static List<DisplayReservationDto> from(List<Reservation> reservations){
        return reservations
                .stream()
                .map(DisplayReservationDto::from)
                .collect(Collectors.toList());
    }
}
