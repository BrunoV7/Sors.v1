package com.app.service;

import com.app.entity.User;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String save(User user) {
        this.userRepository.save(user);
        return "Cadastrado com sucesso!";
    }

    public List<User> listAll() {
        return this.userRepository.findAll();
    }

    public User findById(long id) {
        return this.userRepository.findById(id).get();
    }

    public String update(long id,User user) {
        user.setId(id);
        this.userRepository.save(user);
        return "Atualizado com sucesso!";
    }

}
