package com.javadevmz.jwt_demo.service;

import com.javadevmz.jwt_demo.dto.LoginDto;
import com.javadevmz.jwt_demo.dto.RegisterDto;
import com.javadevmz.jwt_demo.model.Role;
import com.javadevmz.jwt_demo.model.User;
import com.javadevmz.jwt_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtService;

    public String register(RegisterDto dto) {
        User user = new User();
        user.setName(dto.name());
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));

        if (repository.existsByEmail(user.getEmail()))
            throw new IllegalArgumentException("email already taken!");
        if (repository.existsByUsername(user.getUsername()))
            throw new IllegalArgumentException("User with such username already exists!");
        if (!Set.of("STUDENT", "TEACHER").contains(dto.requestedRole()))
            throw new IllegalArgumentException("Invalid role requested");

        user.setRoles(Collections.singleton(Role.valueOf(dto.requestedRole())));

        repository.save(user);
        return jwtService.generateJwt(user);
    }

    public String login(LoginDto dto) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.usernameOrEmail(), dto.password()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        User user = repository.findByUsername(dto.usernameOrEmail());
        if(user==null) user = repository.findByEmail(dto.usernameOrEmail());
        return jwtService.generateJwt(user);
    }
}
