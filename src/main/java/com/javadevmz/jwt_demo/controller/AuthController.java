package com.javadevmz.jwt_demo.controller;

import com.javadevmz.jwt_demo.dto.LoginDto;
import com.javadevmz.jwt_demo.dto.RegisterDto;
import com.javadevmz.jwt_demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public void register(RegisterDto dto) {
        service.register(dto);
    }

    @PostMapping("/login")
    public void login(LoginDto dto) {
        service.login(dto);
    }

}
