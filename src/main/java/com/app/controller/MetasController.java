package com.app.controller;

import com.app.entity.Metas;
import com.app.service.MetasService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/metas")
public class MetasController {

    @Autowired
    private MetasService metasService;

    @Autowired
    private UserService userService;

    @GetMapping("/listall")
    public ResponseEntity<List<Metas>> listAllMetas(){
        try {
            return new ResponseEntity<>(this.metasService.getAllMetas(), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMetas(@RequestBody Metas metas){
        try {
            metas.setUsuario(this.userService.findById(metas.getUsuario().getId()));
            return new ResponseEntity<>(this.metasService.saveMetas(metas), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMetas(@RequestBody Metas metas, @PathVariable Long id){
        try {
            metas.setUsuario(this.userService.findById(metas.getUsuario().getId()));
            return new ResponseEntity<>(this.metasService.updateMetas(metas, id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMetas(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.metasService.deleteMetas(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Metas> findMetasById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.metasService.getMetasById(id), HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
