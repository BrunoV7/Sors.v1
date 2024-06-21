package com.app.repositories;

import com.app.entity.cartao_credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<cartao_credito, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
