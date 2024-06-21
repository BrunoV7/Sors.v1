package com.app.repositories;

import com.app.entity.contas_corrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Contas_cController extends JpaRepository<contas_corrente, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
