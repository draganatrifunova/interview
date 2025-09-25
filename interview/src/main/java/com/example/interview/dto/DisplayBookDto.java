package com.example.interview.dto;

//   public Book(String isbn, String title, String author, LocalDate publishedDate, int availableCopies) {

import com.example.interview.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record DisplayBookDto(String isbn, String title, String author, LocalDate publishedDate, int availableCopies) {
    public static DisplayBookDto from(Book book){
        return new DisplayBookDto(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublishedDate(), book.getAvailableCopies());
    }

    public static List<DisplayBookDto> from(List<Book> books){
        return books.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }
}
