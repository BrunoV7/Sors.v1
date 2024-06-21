package com.app.repositories;

import com.app.entity.Contas_corrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Contas_cController extends JpaRepository<Contas_corrente, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO
}
