package com.example.userservice.controller;

import com.example.userservice.dao.entities.Role;
import com.example.userservice.dao.entities.User;
import com.example.userservice.dto.UserRequest;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*@PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }*/

    @PostMapping
    public User createUser(@Valid @RequestBody UserRequest request) {
        User user = User.builder()
                .keycloakId(request.keycloakId())
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .role(Role.valueOf(request.role()))
                .build();

        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
