package com.app.repositories;

import com.app.entity.metas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetasRepository extends JpaRepository<metas, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
