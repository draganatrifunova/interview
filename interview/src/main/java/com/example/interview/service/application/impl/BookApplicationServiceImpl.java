package com.example.interview.service.application.impl;

import com.example.interview.dto.CreateBookDto;
import com.example.interview.dto.DisplayBookDto;
import com.example.interview.exceptions.BookNotFoundException;
import com.example.interview.exceptions.IsbnAlreadyExistException;
import com.example.interview.service.application.BookApplicationService;
import com.example.interview.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookService bookService;

    public BookApplicationServiceImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public DisplayBookDto addBook(CreateBookDto createBookDto){
        return DisplayBookDto.from(
                this.bookService
                .addBook(createBookDto.toBook()));
    }

    @Override
    public List<DisplayBookDto> listBooks(){
        return this.bookService
                .listBooks()
                .stream().map(DisplayBookDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public DisplayBookDto updateBook(String isbn, CreateBookDto createBookDto){
        return DisplayBookDto.from(this.bookService
                .updateBook(isbn, createBookDto.toBook()));
    }

    @Override
    public void deleteBook(String isbn){
        this.bookService
                .deleteBook(isbn);
    }
}
