package com.app.controller;

import com.app.entity.Saida;
import com.app.entity.Tipo_saida;
import com.app.service.SaidaService;
import com.app.service.TipoSaidaService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saidas")
public class SaidaController {

    @Autowired
    private SaidaService saidaService;

    @Autowired
    private UserService userService;

    @Autowired
    private TipoSaidaService tipoSaidaService;

    @GetMapping("/findall")
    public ResponseEntity<List<Saida>> findAll() {
        try {
            return new ResponseEntity<>(this.saidaService.findAll(), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Saida> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(this.saidaService.findById(id), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Saida saida) {
        try {
            saida.setUsuario(this.userService.findById(saida.getUsuario().getId()));
            saida.setTipo(this.tipoSaidaService.verificar(saida.getTipo().getNome()));
            return new ResponseEntity<>(this.saidaService.novaSaida(saida), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Não foi possivel salvar por: " + e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Saida saida) {
        try {
            saida.setUsuario(this.userService.findById(saida.getUsuario().getId()));
            saida.setTipo(this.tipoSaidaService.verificar(saida.getTipo().getNome()));
            return new ResponseEntity<>(this.saidaService.alterarSaida(id, saida), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(this.saidaService.excluirSaida(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
