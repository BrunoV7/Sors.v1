package com.app.repositories;

import com.app.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
