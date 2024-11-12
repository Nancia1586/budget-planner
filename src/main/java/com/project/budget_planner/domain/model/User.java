package com.project.budget_planner.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;


@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    private String name;
    
    private String firstname;
    
    @Column(unique = true)
    private String pseudo;
    
    @Column(unique = true)
    private String email;
    
    private String password;

    public User() {}

    public User(Long id, String name, String firstname, String pseudo, String email, String password) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    // Must return true, otherwise, the authentication will fail
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPseudo() {
        return pseudo;
    }    

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
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
