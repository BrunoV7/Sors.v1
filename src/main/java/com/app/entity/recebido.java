package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class recebido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @NotNull
    private double valor;

    @Temporal(TemporalType.DATE)
    private Date recebimento;

    @Temporal(TemporalType.DATE)
    private Date dataDeCadastro;

    private String descricao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("conta")
    private User usuario;

    @OneToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("conta")
    private tipo_recebido tipo;
}