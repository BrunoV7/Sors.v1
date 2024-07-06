package com.app.repositories;

import com.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //SÓ AUTOMATICOS POR ENQUANTO

    User findByEmail(String email);
}
