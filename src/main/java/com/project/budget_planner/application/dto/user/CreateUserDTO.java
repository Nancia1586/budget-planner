package com.project.budget_planner.application.dto.user;

public class CreateUserDto {
    private String name;
    private String firstname;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public CreateUserDto() {}

    public CreateUserDto(String name, String firstname, String username, String email, String password, String confirmPassword) {
        this.name = name;
        this.firstname = firstname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }    

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }    

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }    

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }    

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }    

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }    

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
