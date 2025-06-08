package com.javadevmz.jwt_demo.repository;

import com.javadevmz.jwt_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    User findByUsername(String username);
}
