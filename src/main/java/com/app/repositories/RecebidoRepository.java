package com.app.repositories;

import com.app.entity.recebido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecebidoRepository extends JpaRepository<recebido, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
