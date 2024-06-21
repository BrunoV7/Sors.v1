package com.app.controller;

import com.app.entity.Entrada;
import com.app.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Entrada entrada){
        try {
            String resposta = this.entradaService.save(entrada);
            return new ResponseEntity<>(resposta, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Entrada>> listAll(){
        try {
            return new ResponseEntity<>(this.entradaService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Entrada entrada){
        try {
            return new ResponseEntity<>(this.entradaService.update(id, entrada), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        try {
            this.entradaService.delete(id);
            return new ResponseEntity<>(id + "foi apagado!", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Entrada> findById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(this.entradaService.findById(id), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
