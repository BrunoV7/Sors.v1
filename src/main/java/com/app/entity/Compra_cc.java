package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class Compra_cc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String codigo;

    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date cadastro;

    @NotNull
    private double valor;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cartao_credito_id")
    @JsonIgnoreProperties("Compra_cc")
    private Cartao_credito cartao_credito;

}
