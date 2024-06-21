package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class cartao_credito {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String cor;

    private LocalDate fechamento;

    private LocalDate vencimento;

    @OneToMany(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("cartao_credito")
    private List<compra_cc> compra;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("cartao_credito")
    private User usuario;


}
