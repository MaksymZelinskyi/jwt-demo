package com.javadevmz.jwt_demo.controller.impl;

import com.javadevmz.jwt_demo.controller.AuthController;
import com.javadevmz.jwt_demo.dto.AuthResponse;
import com.javadevmz.jwt_demo.dto.LoginDto;
import com.javadevmz.jwt_demo.dto.RegisterDto;
import com.javadevmz.jwt_demo.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthControllerImpl implements AuthController {

    private final AuthService service;

    @Override
    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterDto dto) {
        return new AuthResponse(service.register(dto));
    }

    @Override
    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginDto dto) {
        return new AuthResponse(service.login(dto));
    }

}
