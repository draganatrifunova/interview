package com.example.interview.model;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;


    public Reservation(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public Reservation(){

    }
}
