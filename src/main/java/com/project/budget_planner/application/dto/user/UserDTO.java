package com.project.budget_planner.application.dto.user;

public class UserDto {
    private Long id;
    private String name;
    private String firstname;
    private String pseudo;
    private String email;
    private String password;

    public UserDto() {}

    public UserDto(Long id, String name, String firstname, String pseudo, String email, String password) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
    }

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
}
