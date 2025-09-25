package com.example.interview.service.application;

import com.example.interview.dto.CreateBookDto;
import com.example.interview.dto.DisplayBookDto;
import com.example.interview.exceptions.BookNotFoundException;
import com.example.interview.exceptions.IsbnAlreadyExistException;
import com.example.interview.model.Book;

import java.util.List;

public interface BookApplicationService {
    DisplayBookDto addBook(CreateBookDto createBookDto);

    List<DisplayBookDto> listBooks();

    DisplayBookDto updateBook(String isbn, CreateBookDto createBookDto);

    void deleteBook(String isbn);
}
