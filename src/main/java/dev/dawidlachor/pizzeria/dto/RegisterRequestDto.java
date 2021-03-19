package dev.dawidlachor.pizzeria.dto;

import java.time.LocalDateTime;

public class RegisterRequestDto {
    private String email;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDateTime birth;

    public RegisterRequestDto() {
    }

    public RegisterRequestDto(String email, String login, String password, String firstName, String lastName, String address, LocalDateTime birth) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }
}
