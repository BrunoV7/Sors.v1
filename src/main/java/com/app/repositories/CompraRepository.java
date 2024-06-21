package com.app.repositories;

import com.app.entity.Compra_cc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra_cc, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
