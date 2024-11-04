package com.project.budget_planner.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.budget_planner.application.dto.user.CreateUserDTO;
import com.project.budget_planner.application.dto.user.UserDTO;
import com.project.budget_planner.domain.model.User;
import com.project.budget_planner.domain.service.UserService;

@Service
public class UserApplicationService {
    private final UserService userService;

    public UserApplicationService(UserService userService) {
        this.userService = userService;
    }

    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream()
            .map(user -> new UserDTO(user.getId(), user.getName(), user.getFirstname(), 
                user.getUsername(), user.getEmail(), user.getPassword()))
            .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserByUsername(String username) {
        return userService.getUserByUsername(username)
            .map(user -> new UserDTO(user.getId(), user.getName(), user.getFirstname(), 
                user.getUsername(), user.getEmail(), user.getPassword()));
    }

    public UserDTO createUser(CreateUserDTO userDTO) {
        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())){
            throw new IllegalArgumentException("Password and confirm password do not match");
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setFirstname(userDTO.getFirstname());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User createdUser = userService.createUser(user);
        return new UserDTO(createdUser.getId(), createdUser.getName(), 
            createdUser.getFirstname(), createdUser.getUsername(), createdUser.getEmail(), createdUser.getPassword());
    }

    public void deleteUser(UUID id) {
        userService.deleteUser(id);
    }
}
