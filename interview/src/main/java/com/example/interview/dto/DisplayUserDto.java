package com.example.interview.dto;


import com.example.interview.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//////    public User(String firstName, String lastName, String email, LocalDate membershipDate) {
public record DisplayUserDto(Long id, String firstName, String lastName, String email, LocalDate membershipDate) {
    public static DisplayUserDto from(User user){
        return new DisplayUserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getMembershipDate());
    }

    public static List<DisplayUserDto> from(List<User> users){
        return users
                .stream()
                .map(DisplayUserDto::from)
                .collect(Collectors.toList());
    }
}
