package com.app.service;

import com.app.repositories.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.Entrada;

import java.util.List;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    public String save(Entrada entrada) {
        this.entradaRepository.save(entrada);
        return "Salvo com sucesso!";
    }
    public List<Entrada> findAll() {
        return this.entradaRepository.findAll();
    }

    public Entrada findById(Long id) {
        return this.entradaRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        this.entradaRepository.deleteById(id);
    }

    public String update(int id, Entrada entrada) {
        entrada.setId(id);
        this.entradaRepository.save(entrada);
        return "Atualizado com sucesso!";
    }
}
