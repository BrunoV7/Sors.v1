package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
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

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<conta> contas;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<cartao_credito> cartoes;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<metas> metas;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<contas_corrente> contas_corrente;

}
