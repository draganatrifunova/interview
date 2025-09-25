package com.example.interview.repository;

import com.example.interview.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUserEmail(String email);
    List<Reservation> findAllByBookIsbn(String isbn);
    List<Reservation> findAllByUserEmailAndBookIsbn(String email, String isbn);
}
