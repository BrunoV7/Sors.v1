package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class metas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String meta;

    private double gastos;

    private double ganhos;

    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("metas")
    private User usuario;

}
