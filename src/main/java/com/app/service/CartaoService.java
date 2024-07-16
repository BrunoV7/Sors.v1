package com.app.service;

import com.app.entity.Cartao_credito;
import com.app.entity.User;
import com.app.repositories.CartaoRepository;
import com.app.repositories.UserRepository;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Cartao_credito> listarCartoes(){
        return cartaoRepository.findAll();
    }

    public Cartao_credito buscarCartao(Long id){
        return cartaoRepository.findById(id).orElse(null);
    }

    public String salvarCartao(Cartao_credito cartao){
        if(cartao == null){
            return "Objeto invalido!";
        }else{
            cartaoRepository.save(cartao);
            return "Cartao Salvo com sucesso!";
        }
    }

    public String AtualizarCartao(Long id, Cartao_credito cartao){
        if(cartao == null){
            return "Objeto invalido!";
        }else{
            cartao.setId(id);
            cartaoRepository.save(cartao);
            return "Cartao Atualizado com sucesso!";
        }
    }

    public String excluirCartao(Long id){
        cartaoRepository.deleteById(id);
        return "Cartao Excluido com sucesso!";
    }

    public User buscarUsuario(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceClosedException("Usuario não encontrado!"));
    }

}
