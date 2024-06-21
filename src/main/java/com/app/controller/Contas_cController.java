package com.app.controller;

import com.app.entity.Contas_corrente;
import com.app.entity.User;
import com.app.service.ContasCService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corrente")
public class Contas_cController {

    @Autowired
    ContasCService contasCService;

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Contas_corrente corrente) {
        try {
            corrente.setUsuario(this.userService.findById(corrente.getUsuario().getId()));
            return new ResponseEntity<>(this.contasCService.novaConta(corrente), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(Long id, @RequestBody Contas_corrente corrente) {
        try {
            corrente.setUsuario(this.userService.findById(corrente.getUsuario().getId()));
            return new ResponseEntity<>(this.contasCService.atualizarConta(id, corrente), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Contas_corrente>> listAll() {
        try {
            return new ResponseEntity<>(this.contasCService.listarContas(), HttpStatus.FOUND);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Contas_corrente> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(this.contasCService.buscarContaPorId(id), HttpStatus.FOUND);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(this.contasCService.excluirConta(id), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
