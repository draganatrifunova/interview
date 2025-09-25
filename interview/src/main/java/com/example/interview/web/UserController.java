package com.example.interview.web;

import com.example.interview.dto.CreateUserDto;
import com.example.interview.dto.DisplayUserDto;
import com.example.interview.service.application.UserApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayUserDto> addUser(@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.ok(this.userApplicationService
                .addUser(createUserDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<DisplayUserDto>> listUsers(){
        return ResponseEntity.ok(this.userApplicationService
                .listUsers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DisplayUserDto> updateUser(@PathVariable Long id, @RequestBody CreateUserDto createUserDto){
        return ResponseEntity.ok(this.userApplicationService
                .updateUser(id, createUserDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        this.userApplicationService
                .deleteUser(id);

        return ResponseEntity
                .noContent().build();
    }
}
