package com.example.interview.service.domain;

import com.example.interview.exceptions.EmailAlreadyExistException;
import com.example.interview.exceptions.UserNotFoundException;
import com.example.interview.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> listUsers();

    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
