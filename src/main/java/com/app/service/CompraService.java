package com.app.service;

import com.app.entity.Compra_cc;
import com.app.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public String novaCompra(Compra_cc compra){
        compraRepository.save(compra);
        return "Compra cadastrada com sucesso!";
    }

    public String atualizarCompra(Long id,Compra_cc compra){
        compra.setId(id);
        compraRepository.save(compra);
        return "Compra atualizada com sucesso!";
    }

    public String excluirCompra(Long id){
        compraRepository.deleteById(id);
        return "Compra removida com sucesso!";
    }

    public Compra_cc buscarPorId(Long id){
        return compraRepository.findById(id).orElse(null);
    }

    public List<Compra_cc> buscarTodos(){
        return compraRepository.findAll();
    }

}
