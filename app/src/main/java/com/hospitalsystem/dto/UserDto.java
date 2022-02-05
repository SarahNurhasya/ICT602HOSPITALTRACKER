package com.hospitalsystem.dto;

public class UserDto {

    private String email;
    private String firstname;
    private String lastname;

    public UserDto(String email, String firstname, String lastname) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
