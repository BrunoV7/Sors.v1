package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contas_corrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String cor;

    @NotNull
    private double saldo_inicial;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("contas_corrente")
    private User usuario;

}
