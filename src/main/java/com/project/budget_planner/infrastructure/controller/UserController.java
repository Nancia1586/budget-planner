package com.project.budget_planner.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.budget_planner.application.dto.user.CreateUserDto;
import com.project.budget_planner.application.dto.user.LoginUserDto;
import com.project.budget_planner.application.dto.user.UserDto;
import com.project.budget_planner.application.service.JwtService;
import com.project.budget_planner.application.service.UserApplicationService;
import com.project.budget_planner.domain.model.User;
import com.project.budget_planner.infrastructure.response.LoginResponse;

@RestController
@RequestMapping("/users")
public class UserController {
    private final JwtService jwtService;
    private final UserApplicationService userApplicationService;

    public UserController(JwtService jwtService, UserApplicationService userApplicationService) {
        this.jwtService = jwtService;
        this.userApplicationService = userApplicationService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userApplicationService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserDto> getUserById(@PathVariable Long id) {
        return userApplicationService.getUserById(id);
    }

    @GetMapping("/current")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto userDTO) {
        UserDto registeredUser = userApplicationService.createUser(userDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = userApplicationService.signin(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userApplicationService.deleteUser(id);
    }
}
