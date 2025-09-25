package com.example.interview.dto;

import com.example.interview.model.User;

import java.time.LocalDate;

////    public User(String firstName, String lastName, String email, LocalDate membershipDate) {
public record CreateUserDto(String firstName, String lastName, String email, LocalDate membershipDate) {

    public User toUser(){
        return new User(firstName, lastName, email, membershipDate);
    }
}
