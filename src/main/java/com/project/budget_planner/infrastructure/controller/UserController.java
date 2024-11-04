package com.project.budget_planner.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.budget_planner.application.dto.user.CreateUserDTO;
import com.project.budget_planner.application.dto.user.UserDTO;
import com.project.budget_planner.application.service.UserApplicationService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userApplicationService.getAllUsers();
    }

    @GetMapping("/{username}")
    public Optional<UserDTO> getUserByUsername(@PathVariable String username) {
        return userApplicationService.getUserByUsername(username);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody CreateUserDTO userDTO) {
        return userApplicationService.createUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userApplicationService.deleteUser(id);
    }
}
