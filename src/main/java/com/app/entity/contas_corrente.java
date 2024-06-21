package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class contas_corrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cor;

    private String saldo_inicial;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("contas_corrente")
    private User usuario;

}
