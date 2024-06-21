package com.app.service;

import com.app.entity.Tipo_recebido;
import com.app.repositories.Tipo_recebidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoRecebidoService {

    @Autowired
    Tipo_recebidoRepository tipoEntradaRepository;

    public Tipo_recebido verificar(String novoTipo) {
        if (tipoEntradaRepository.findByNome(novoTipo) == null) {
            Tipo_recebido tipoRecebido = new Tipo_recebido();
            tipoRecebido.setNome(novoTipo);
            this.tipoEntradaRepository.save(tipoRecebido);
            return tipoRecebido;
        }else{
            return tipoEntradaRepository.findByNome(novoTipo);
        }
    }
}
