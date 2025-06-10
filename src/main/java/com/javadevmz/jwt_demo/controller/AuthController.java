package com.javadevmz.jwt_demo.controller;

import com.javadevmz.jwt_demo.dto.AuthResponse;
import com.javadevmz.jwt_demo.dto.LoginDto;
import com.javadevmz.jwt_demo.dto.RegisterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Authentication controller",
     description = "Provides endpoints for creating an account and for signing into an existing account"
)
public interface AuthController {

    @Operation(description = "Takes credentials for creating an account and a role requested. Registers the user and returns the jwt generated")
    AuthResponse register(RegisterDto dto);

    @Operation(description = "Takes login credentials. Allows access if the the password matches the username and the jwt-token provided is valid")
    AuthResponse login(LoginDto dto);
}
