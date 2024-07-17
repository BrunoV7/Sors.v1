package com.app.auth.Services;

import com.app.entity.Login;
import com.app.entity.User;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class servicesS {
    @Service
    public static class AuthenticationServices {

        @Autowired
        private UserRepository userRepository;

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
}
