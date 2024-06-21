package com.app.repositories;

import com.app.entity.compra_cc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<compra_cc, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
