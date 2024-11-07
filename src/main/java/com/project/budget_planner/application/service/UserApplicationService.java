package com.project.budget_planner.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.budget_planner.application.dto.user.CreateUserDto;
import com.project.budget_planner.application.dto.user.LoginUserDto;
import com.project.budget_planner.application.dto.user.UserDto;
import com.project.budget_planner.domain.model.User;
import com.project.budget_planner.domain.service.UserService;

@Service
public class UserApplicationService {
    private final UserService userService;

    public UserApplicationService(UserService userService) {
        this.userService = userService;
    }

    public UserDto createUser(CreateUserDto userDTO) {
        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())){
            throw new IllegalArgumentException("Password and confirm password do not match");
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setFirstname(userDTO.getFirstname());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User createdUser = userService.creatUser(user);
        return new UserDto(createdUser.getId(), createdUser.getName(), 
            createdUser.getFirstname(), createdUser.getUsername(), createdUser.getEmail(), 
            createdUser.getPassword());
    }

    public User signin(LoginUserDto loginInfo) {
        User user = userService.signin(loginInfo.getEmail(), loginInfo.getPassword());
        return new User(user.getId(), user.getName(), user.getFirstname(), user.getUsername(), 
            user.getEmail(), user.getPassword());
    }

    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
            .map(user -> new UserDto(user.getId(), user.getName(), user.getFirstname(), 
                user.getUsername(), user.getEmail(), user.getPassword()))
            .collect(Collectors.toList());
    }

    public Optional<UserDto> getUserByUsername(String username) {
        return userService.getUserByUsername(username)
            .map(user -> new UserDto(user.getId(), user.getName(), user.getFirstname(), 
                user.getUsername(), user.getEmail(), user.getPassword()));
    }

    public void deleteUser(UUID id) {
        userService.deleteUser(id);
    }
}
