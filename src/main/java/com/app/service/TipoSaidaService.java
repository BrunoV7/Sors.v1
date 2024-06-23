package com.app.service;

import com.app.entity.Tipo_saida;
import com.app.repositories.Tipo_saidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoSaidaService {

    @Autowired
    Tipo_saidaRepository tipo_saidaRepository;

    public Tipo_saida verificar(String novoTipo) {
        if(tipo_saidaRepository.findByNome(novoTipo)!=null){
            return tipo_saidaRepository.findByNome(novoTipo);
        }else{
            Tipo_saida tipo_saida = new Tipo_saida();
            tipo_saida.setNome(novoTipo);
            this.tipo_saidaRepository.save(tipo_saida);
            return tipo_saida;
        }
    }

}
