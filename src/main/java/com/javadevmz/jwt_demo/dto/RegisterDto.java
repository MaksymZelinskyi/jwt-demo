package com.javadevmz.jwt_demo.dto;

public record RegisterDto(String name, String username, String email, String password, String requestedRole) {
}
