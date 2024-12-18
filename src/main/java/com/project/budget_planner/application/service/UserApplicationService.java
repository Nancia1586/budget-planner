package com.project.budget_planner.application.service;

import java.util.List;
import java.util.Optional;
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

    private UserDto toUserDto(User user) {
        return new UserDto(
            user.getId(), 
            user.getName(), 
            user.getFirstname(), 
            user.getPseudo(), 
            user.getEmail(), 
            user.getPassword()
        );
    }

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
        user.setPseudo(userDTO.getPseudo());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User createdUser = userService.createUser(user);
        return toUserDto(createdUser);
    }

    public User signin(LoginUserDto loginInfo) {
        User user = userService.signin(loginInfo.getEmail(), loginInfo.getPassword());
        return new User(user.getId(), user.getName(), user.getFirstname(), user.getPseudo(), 
            user.getEmail(), user.getPassword());
    }

    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
            .map(this::toUserDto)
            .collect(Collectors.toList());
    }

    public Optional<UserDto> getUserByPseudo(String username) {
        return userService.getUserByPseudo(username)
            .map(this::toUserDto);
    }

    public Optional<UserDto> getUserById(Long id) {
        return userService.getUserById(id)
            .map(this::toUserDto);
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
