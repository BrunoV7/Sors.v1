package com.app.auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RegisterDTO {
    private String email;
    private String username;
    private String password;
    private Date birthdate;

    public RegisterDTO() {
    }

    public RegisterDTO(String email, String username, Date birthdate) {
        this.email = email;
        this.username = username;
        this.birthdate = birthdate;
    }
}