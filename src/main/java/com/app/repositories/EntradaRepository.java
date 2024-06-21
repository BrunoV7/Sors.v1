package com.app.repositories;

import com.app.entity.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
