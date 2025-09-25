package com.example.interview.service.domain.impl;

import com.example.interview.exceptions.EmailAlreadyExistException;
import com.example.interview.exceptions.UserNotFoundException;
import com.example.interview.model.User;
import com.example.interview.repository.UserRepository;
import com.example.interview.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user){
        if (this.userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException();
        }

        return this.userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return this.userRepository
                .findAll();
    }

    @Override
    public User updateUser(Long id, User user){
        User u = this.userRepository
                .findById(id)
                .orElseThrow(UserNotFoundException::new);

        u.setEmail(user.getEmail());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setMembershipDate(user.getMembershipDate());

        return this.userRepository.save(u);
    }

    @Override
    public void deleteUser(Long id){
        User user = this.userRepository
                .findById(id)
                .orElseThrow(UserNotFoundException::new);


        this.userRepository.delete(user);
    }
}
