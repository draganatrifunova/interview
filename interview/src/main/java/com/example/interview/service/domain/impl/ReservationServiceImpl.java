package com.example.interview.service.domain.impl;

import com.example.interview.exceptions.BookNotFoundException;
import com.example.interview.exceptions.BookOutOfStockException;
import com.example.interview.exceptions.ReservationNotFoundException;
import com.example.interview.exceptions.UserNotFoundException;
import com.example.interview.model.Book;
import com.example.interview.model.Reservation;
import com.example.interview.model.User;
import com.example.interview.repository.BookRepository;
import com.example.interview.repository.ReservationRepository;
import com.example.interview.repository.UserRepository;
import com.example.interview.service.domain.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Reservation reserveBook(String userEmail, String isbn){
        Book book = this.bookRepository
                .findBookByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(""));

        User user = this.userRepository
                .findUserByEmail(userEmail)
                .orElseThrow(UserNotFoundException::new);

        book.decreaseAvailableCopies();
        this.bookRepository.save(book);

        Reservation reservation = new Reservation(book, user);
        return this.reservationRepository.save(reservation);
    }

    @Override
    public void returnBook(Long reservationId){
        Reservation reservation = this.reservationRepository
                .findById(reservationId)
                .orElseThrow(ReservationNotFoundException::new);

        Book book = reservation.getBook();
        book.increaseAvailableCopies();
        this.bookRepository.save(book);

        this.reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> listReservations(String userEmail, String isbn) {
        if (userEmail == null && isbn == null) {
            return this.reservationRepository
                    .findAll();
        } else if (userEmail != null && isbn != null) {
            return this.reservationRepository
                    .findAllByUserEmailAndBookIsbn(userEmail, isbn);
        } else if (userEmail != null) {
            return this.reservationRepository
                    .findAllByUserEmail(userEmail);
        } else {
            return this.reservationRepository
                    .findAllByBookIsbn(isbn);
        }
    }
}
