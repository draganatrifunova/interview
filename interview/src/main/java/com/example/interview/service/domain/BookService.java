package com.example.interview.service.domain;

import com.example.interview.exceptions.BookNotFoundException;
import com.example.interview.exceptions.IsbnAlreadyExistException;
import com.example.interview.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    List<Book> listBooks();

    Book updateBook(String isbn, Book book);
    void deleteBook(String isbn);

}
