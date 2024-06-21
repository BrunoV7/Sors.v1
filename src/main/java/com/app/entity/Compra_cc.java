package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Compra_cc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String descricao;

    private LocalDateTime data_cadastro;

    private double valor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("compra_cc")
    private Cartao_credito cartao_credito;

}
