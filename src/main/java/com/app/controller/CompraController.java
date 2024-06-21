package com.app.controller;

import com.app.entity.Compra_cc;
import com.app.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping("/findall")
    public ResponseEntity<List<Compra_cc>> compras(){
        try {
            return new ResponseEntity<>(this.compraService.buscarTodos(), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Compra_cc> findById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.compraService.buscarPorId(id), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Compra_cc compra){
        try {
            return new ResponseEntity<>(this.compraService.novaCompra(compra), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Compra_cc compra){
        try {
            return new ResponseEntity<>(this.compraService.atualizarCompra(id, compra), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.compraService.excluirCompra(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
