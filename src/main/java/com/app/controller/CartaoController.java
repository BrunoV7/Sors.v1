package com.app.controller;

import com.app.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.app.entity.Cartao_credito;

@RestController
@RequestMapping("/api/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping("/findall")
    public ResponseEntity<List<Cartao_credito>> findAll(){
        try {
            return new ResponseEntity<>(this.cartaoService.listarCartoes(), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Cartao_credito> findbyid(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.cartaoService.buscarCartao(id), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Cartao_credito cartao){
        try {
            cartao.setUsuario(this.cartaoService.buscarUsuario(cartao.getUsuario().getId()));
            return new ResponseEntity<>(this.cartaoService.salvarCartao(cartao), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Falha ao inserir Cartão por:" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Cartao_credito cartao){
        try {
            cartao.setUsuario(this.cartaoService.buscarUsuario(cartao.getUsuario().getId()));
            return new ResponseEntity<>(this.cartaoService.AtualizarCartao(id, cartao), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.cartaoService.excluirCartao(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
