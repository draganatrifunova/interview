package com.example.interview.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name can not be empty")
    private String firstName;
    private String lastName;


    @NotBlank(message = "Email can not be blank")
    @Column(unique = true, nullable = false)
    private String email;

    private LocalDate membershipDate;

    public User(String firstName, String lastName, String email, LocalDate membershipDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.membershipDate = membershipDate;
    }

    public User(){

    }
}
