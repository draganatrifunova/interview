package com.example.interview.console;

import com.example.interview.dto.CreateBookDto;
import com.example.interview.dto.DisplayBookDto;
import com.example.interview.service.application.BookApplicationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LibraryConsole {
    private final Scanner scanner;
    private final BookApplicationService bookApplicationService;

    public LibraryConsole(Scanner scanner, BookApplicationService bookApplicationService) {
        this.scanner = scanner;
        this.bookApplicationService = bookApplicationService;
    }

    public void run() {
        while (true) {
            System.out.println("Enter command: 1)addBook  2)listBooks  3)updateBook  4)deleteBook  5)exit");
            System.out.println("PROPER SYNTAX: addBook <isbn[String]> <title[String]> <author[String]> <publishedDate[LocalDate]> <availableCopies[int]>");
            System.out.println("PROPER SYNTAX: listBooks");
            System.out.println("PROPER SYNTAX: updateBook <isbn[String]> <title[String]> <author[String]> <publishedDate[LocalDate]> <availableCopies[int]>");
            System.out.println("PROPER SYNTAX: deleteBook <isbn[String]>");
            System.out.println("PROPER SYNTAX: exit");

            String command = scanner.nextLine();
            String[] words = command.split("\\s+");

            switch (words[0]) {
                case "addBook":
                    if (words.length == 6) {
                        String isbn = words[1];
                        String title = words[2];
                        String author = words[3];
                        LocalDate publishedDate = LocalDate.parse(words[4]);
                        int availableCopies = Integer.parseInt(words[5]);
                        CreateBookDto createBookDto = new CreateBookDto(isbn, title, author, publishedDate, availableCopies);
                        bookApplicationService.addBook(createBookDto);
                    }
                    break;
                case "listBooks":
                    if (words.length == 1) {
                        List<DisplayBookDto> ll = bookApplicationService.listBooks();
                        for (DisplayBookDto b : ll) {
                            System.out.println(b);
                        }
                    }
                    break;
                case "updateBook":
                    if (words.length == 6) {
                        String isbn = words[1];
                        String title = words[2];
                        String author = words[3];
                        LocalDate publishedDate = LocalDate.parse(words[4]);
                        int availableCopies = Integer.parseInt(words[5]);
                        CreateBookDto createBookDto = new CreateBookDto(isbn, title, author, publishedDate, availableCopies);
                        bookApplicationService.updateBook(isbn, createBookDto);
                    }
                    break;
                case "deleteBook":
                    if (words.length == 2) {
                        String isbn = words[1];
                        this.bookApplicationService.deleteBook(isbn);
                    }
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }

    }
}
