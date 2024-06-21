package com.app.service;

import com.app.entity.Saida;
import com.app.repositories.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaidaService {

    @Autowired
    private SaidaRepository saidaRepository;

    public List<Saida> findAll() {
        return saidaRepository.findAll();
    }

    public Saida findById(Long id) {
        return saidaRepository.findById(id).orElse(null);
    }

    public String novaSaida(Saida saida) {
        this.saidaRepository.save(saida);
        return "Saída adicionada com sucesso!";
    }

    public String alterarSaida(Long id, Saida saida) {
        saida.setId(id);
        this.saidaRepository.save(saida);
        return "Alterado com sucesso!";
    }

    public String excluirSaida(Long id) {
        saidaRepository.deleteById(id);
        return "Excluido com sucesso!";
    }

}
