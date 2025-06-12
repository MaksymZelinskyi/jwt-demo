package com.javadevmz.jwt_demo.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(@NotBlank String usernameOrEmail,@NotBlank String password) {

}
