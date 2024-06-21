package com.app.service;

import com.app.entity.Metas;
import com.app.repositories.MetasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetasService {

    @Autowired
    private MetasRepository metasRepository;

    public List<Metas> getAllMetas(){
        return metasRepository.findAll();
    }

    public Metas getMetasById(Long id){
        return this.metasRepository.findById(id).orElse(null);
    }

    public String saveMetas(Metas metas){
        this.metasRepository.save(metas);
        return "Salvo com sucesso!";
    }

    public String updateMetas(Metas metas, Long id){
        metas.setId(id);
        this.metasRepository.save(metas);
        return "Alterado com sucesso!";
    }

    public String deleteMetas(Long id){
        this.metasRepository.deleteById(id);
        return "Deletado com sucesso!";
    }
}
