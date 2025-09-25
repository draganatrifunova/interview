package com.example.interview.service.application;

import com.example.interview.dto.CreateUserDto;
import com.example.interview.dto.DisplayUserDto;
import com.example.interview.exceptions.EmailAlreadyExistException;
import com.example.interview.exceptions.UserNotFoundException;
import com.example.interview.model.User;

import java.util.List;

public interface UserApplicationService {
    DisplayUserDto addUser(CreateUserDto createUserDto);

    List<DisplayUserDto> listUsers();

    DisplayUserDto updateUser(Long id, CreateUserDto createUserDto);

    void deleteUser(Long id);
}
