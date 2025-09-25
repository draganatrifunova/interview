package com.example.interview.service.application.impl;

import com.example.interview.dto.CreateUserDto;
import com.example.interview.dto.DisplayUserDto;
import com.example.interview.exceptions.EmailAlreadyExistException;
import com.example.interview.exceptions.UserNotFoundException;
import com.example.interview.service.application.UserApplicationService;
import com.example.interview.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserService userService;

    public UserApplicationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public DisplayUserDto addUser(CreateUserDto createUserDto){
        return DisplayUserDto.from(this.userService
                .addUser(createUserDto.toUser()));
    }

    @Override
    public List<DisplayUserDto> listUsers(){
        return DisplayUserDto.from(this.userService
                .listUsers());
    }

    @Override
    public DisplayUserDto updateUser(Long id, CreateUserDto createUserDto){
        return DisplayUserDto.from(this.userService
                .updateUser(id, createUserDto.toUser()));
    }

    @Override
    public void deleteUser(Long id){
        this.userService
                .deleteUser(id);
    }
}
