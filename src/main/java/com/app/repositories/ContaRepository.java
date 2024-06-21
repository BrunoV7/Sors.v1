package com.app.repositories;

import com.app.entity.conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<conta, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
