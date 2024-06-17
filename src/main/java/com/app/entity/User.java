package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @OneToMany(mappedBy = "conta")
    @JsonIgnoreProperties("conta")
    private List<Conta> contas;

}
