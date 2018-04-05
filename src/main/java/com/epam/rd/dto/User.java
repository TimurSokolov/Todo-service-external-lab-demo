package com.epam.rd.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.epam.rd.enums.UserRole;

public class User {

    private Long id;

    @NotNull(message = "Неверно заполнен логин")
    @Size(min = 3, max = 20, message = "Неверно заполнен логин")
    private String login;
    
    private String name;
    
    @NotNull(message = "Неверно заполнен емейл")
    private String email;
    
    private UserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
