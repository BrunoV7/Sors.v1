package com.app.service;

import com.app.entity.Login;
import com.app.entity.User;
import com.app.repositories.UserRepository;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

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
        return userRepository.findById(id).orElseThrow(() -> new ResourceClosedException("Usuario não encontrado!"));
    }

    public String update(long id,User user) {
        user.setId(id);
        this.userRepository.save(user);
        return "Atualizado com sucesso!";
    }

    public String delete(long id) {
        this.userRepository.deleteById(id);
        return "Deletado com sucesso!";
    }

    public User logar(Login user) throws Exception {
        // Busca o usuário no repositório pelo email fornecido
        User UserTest = this.userRepository.findByEmail(user.getEmail());

        // Verifica se o usuário existe
        if (UserTest == null) {
            System.out.println("Usuário não encontrado");
            throw new Exception("Usuario não encontrado!"); // Usuário não encontrado
        } else {
            // Compara as senhas
            if (UserTest.getPassword().equals(user.getPassword())) {
                System.out.println("Senha correta");
                return UserTest; // Login bem-sucedido
            } else {
                System.out.println("Senha incorreta");
                throw new Exception("Senha incorreta!"); // Senha incorreta
            }
        }
    }


}
