package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Cartao_credito {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String descricao;

    private String cor;

    @NotNull
    private int digitos;

    @NotNull
    private int vencimento;

    @OneToMany(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("cartao_credito")
    private List<Compra_cc> compras;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("cartao_credito")
    private User usuario;

}
