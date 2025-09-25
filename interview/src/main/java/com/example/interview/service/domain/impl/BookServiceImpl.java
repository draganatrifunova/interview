package com.example.interview.service.domain.impl;

import com.example.interview.exceptions.BookNotFoundException;
import com.example.interview.exceptions.IsbnAlreadyExistException;
import com.example.interview.model.Book;
import com.example.interview.repository.BookRepository;
import com.example.interview.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book){
        if(this.bookRepository.findBookByIsbn(book.getIsbn()).isPresent()){
            throw new IsbnAlreadyExistException();
        }
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> listBooks(){
        return this.bookRepository
                .findAll();
    }

    @Override
    public Book updateBook(String isbn, Book book){
        Book b = this.bookRepository
                .findBookByIsbn(isbn)
                .orElseThrow(BookNotFoundException::new);

        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        b.setAvailableCopies(book.getAvailableCopies());
        b.setPublishedDate(book.getPublishedDate());
        return this.bookRepository.save(b);
    }

    @Override
    public void deleteBook(String isbn){

        Book book = this.bookRepository
                .findBookByIsbn(isbn)
                .orElseThrow(BookNotFoundException::new);

        this.bookRepository.delete(book);

    }
}
