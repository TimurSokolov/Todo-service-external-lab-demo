package com.epam.rd.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.epam.rd.enums.UserRole;

public class User {

	private Long id;

	@NotEmpty(message = "Не заполнен логин")
	private String login;

	@NotEmpty(message = "Не заполнено имя")
	private String name;

	@NotEmpty(message = "Не заполнен емейл")
	private String email;

	private UserRole role;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birthday;

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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

}
