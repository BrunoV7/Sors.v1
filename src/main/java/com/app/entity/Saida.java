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
public class Saida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @NotNull
    private double valor;

    @Temporal(TemporalType.DATE)
    private Date vencimento;

    @Temporal(TemporalType.DATE)
    private Date dataDeCadastro;

    private String descricao;

    @OneToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("Saida")
    private Tipo_saida tipo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("Saida")
    private User usuario;

}
