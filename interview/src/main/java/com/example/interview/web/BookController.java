package com.example.interview.web;


import com.example.interview.dto.CreateBookDto;
import com.example.interview.dto.DisplayBookDto;
import com.example.interview.service.application.BookApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookApplicationService bookApplicationService;

    public BookController(BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> addBook(@RequestBody CreateBookDto createBookDto){
        return ResponseEntity.ok(this.bookApplicationService
                .addBook(createBookDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<DisplayBookDto>> listBooks(){
        return ResponseEntity.ok(this.bookApplicationService
                .listBooks());
    }

    @PutMapping("/update/{isbn}")
    public ResponseEntity<DisplayBookDto> updateBook(@PathVariable String isbn,
                                     @RequestBody CreateBookDto createBookDto){
        return ResponseEntity.ok(this.bookApplicationService
                .updateBook(isbn, createBookDto));

    }

    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn){
        this.bookApplicationService
                .deleteBook(isbn);

        return ResponseEntity
                .noContent().build();
    }
}
