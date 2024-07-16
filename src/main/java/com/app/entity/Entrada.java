package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Entrada {
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
    private Date cadastro;

    private String descricao;

    @OneToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("Entrada")
    private Tipo_recebido tipo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("Entrada")
    private User usuario;
}
