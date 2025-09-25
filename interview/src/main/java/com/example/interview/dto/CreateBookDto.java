package com.example.interview.dto;

import com.example.interview.model.Book;

import java.time.LocalDate;

//   public Book(String isbn, String title, String author, LocalDate publishedDate, int availableCopies) {
public record CreateBookDto(String isbn, String title, String author, LocalDate publishedDate, int availableCopies) {

    public Book toBook(){
        return new Book(isbn, title, author, publishedDate, availableCopies);
    }
}
