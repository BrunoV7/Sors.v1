package com.app.auth.Controller;

import com.app.auth.dto.AuthenticationDTO;
import com.app.auth.dto.RegisterDTO;
import com.app.entity.Login;
import com.app.entity.User;
import com.app.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity logar(@RequestBody @Valid AuthenticationDTO data) {
        try {
            String password = new BCryptPasswordEncoder().encode(data.password());
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), password);
            var auth = this.authenticationManager.authenticate(usernamePassword);
            return new ResponseEntity<>(auth, HttpStatus.OK);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByEmail(data.getEmail()) != null) return ResponseEntity.badRequest().build();
        else {
            String password = new BCryptPasswordEncoder().encode(data.getPassword());
            data.setPassword(password);
            User newUser = new User();
            newUser.setEmail(data.getEmail());
            newUser.setPassword(password);
            newUser.setUsername(data.getUsername());
            newUser.setBirthdate(data.getBirthdate());
            newUser.setRole("USER");
            this.userRepository.save(newUser);
            return ResponseEntity.ok().build();
        }
    }

}
