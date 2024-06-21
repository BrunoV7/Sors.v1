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
public class Metas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String meta;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date objetivo;

    @NotNull
    private double gastos;

    @NotNull
    private double ganhos;

    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("metas")
    private User usuario;

}
