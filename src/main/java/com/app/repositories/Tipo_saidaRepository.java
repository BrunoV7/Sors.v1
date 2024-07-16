package com.app.repositories;

import com.app.entity.Tipo_saida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Tipo_saidaRepository extends JpaRepository<Tipo_saida, Long> {

    @Query("SELECT tipo FROM Tipo_saida tipo WHERE tipo.nome LIKE CONCAT('%', :nome, '%')")
    public Tipo_saida findByNome(@Param("nome") String nome);

}
