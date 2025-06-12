package com.javadevmz.jwt_demo.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterDto(@NotBlank String name, @NotBlank String username, @NotBlank String email, @NotBlank String password, String requestedRole) {
}
