package com.app.service;

import com.app.entity.Contas_corrente;
import com.app.repositories.Contas_cRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasCService {

    @Autowired
    Contas_cRepository contas_cRepository;

    public String novaConta(Contas_corrente contas_corrente) {
        contas_cRepository.save(contas_corrente);
        return "Salvo com sucesso!";
    }

    public String atualizarConta(Long id, Contas_corrente contas_corrente) {
        contas_corrente.setId(id);
        contas_cRepository.save(contas_corrente);
        return "Atualizado com sucesso!";
    }

    public String excluirConta(long id) {
        contas_cRepository.deleteById(id);
        return "Excluido com sucesso!";
    }

    public List<Contas_corrente> listarContas() {
        return contas_cRepository.findAll();
    }

    public Contas_corrente buscarContaPorId(long id) {
        return contas_cRepository.findById(id).get();
    }

}
