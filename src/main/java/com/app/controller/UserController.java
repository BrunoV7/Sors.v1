package com.app.controller;

import com.app.entity.Login;
import com.app.entity.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

    //CREATE READ UPDATE DELETE

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User user) {
        try {
            String resposta = this.userService.save(user);
            return new ResponseEntity<>(resposta, HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>("Falhou! objeto não foi lido!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<User>> listAll() {
        try {
            List<User> resposta = this.userService.listAll();
            return new ResponseEntity<>(resposta, HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        try {
            User resposta = this.userService.findById(id);
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody User user) {
        try {
            String resposta = this.userService.update(id,user);
            return new ResponseEntity<>(resposta, HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>("Falhou! objeto não foi lido!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            String resposta = this.userService.delete(id);
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>("Falha ao deletar!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/hi")
    public ResponseEntity<String> hi() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @PostMapping("/logar")
    public ResponseEntity<User> logar(@RequestBody Login user) {
        try {
            return new ResponseEntity<>(this.userService.logar(user), HttpStatus.ACCEPTED);
        }catch (Exception e){
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
