package com.app.repositories;

import com.app.entity.Cartao_credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao_credito, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
