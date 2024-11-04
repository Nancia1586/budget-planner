package com.project.budget_planner.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

import jakarta.persistence.Column;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue()
    private UUID id;
    
    private String name;
    
    private String firstname;
    
    @Column(unique = true)
    private String username;
    
    @Column(unique = true)
    private String email;
    
    private String password;

    public User() {}

    public User(UUID id, String name, String firstname, String username, String email, String password) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
