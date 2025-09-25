package com.example.interview;

import com.example.interview.console.LibraryConsole;
import com.example.interview.service.application.BookApplicationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;


@SpringBootApplication
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}


	@Bean
	public CommandLineRunner runConsole(BookApplicationService bookApplicationService) {
		return args -> {
			LibraryConsole console = new LibraryConsole(new Scanner(System.in), bookApplicationService);
			console.run();
		};
	}

}
