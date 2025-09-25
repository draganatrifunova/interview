package com.example.interview.model;


import com.example.interview.exceptions.BookOutOfStockException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
public class Book {
    @Column(nullable = false)
    @NotBlank(message = "Title can not be blank")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    @Column(nullable = false)
    private String author;

    @Id
    @Column(nullable = false, unique = true)
    private String isbn;

    private LocalDate publishedDate;

    private int availableCopies;


    public Book(String isbn, String title, String author, LocalDate publishedDate, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.availableCopies = availableCopies;
    }

    public Book() {

    }

    //MAYBE I DO NOT HAVE ANY REASON FOR SYNCHRONIZATION / I MUST CHECK
    public synchronized void increaseAvailableCopies() {
        this.availableCopies++;
    }

    public synchronized void decreaseAvailableCopies(){
        if (this.availableCopies == 0) {
            throw new BookOutOfStockException("Book quantity is out of stock. We do not have that book anymore");
        }
        this.availableCopies--;
    }
}
