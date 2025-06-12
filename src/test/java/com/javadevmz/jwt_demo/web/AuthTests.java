package com.javadevmz.jwt_demo.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javadevmz.jwt_demo.controller.AuthController;
import com.javadevmz.jwt_demo.dto.LoginDto;
import com.javadevmz.jwt_demo.dto.RegisterDto;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class AuthTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void testRegister() throws Exception {
        RegisterDto dto = new RegisterDto("name", "username", "user@springmail.com", "password", "TEACHER");
        mockMvc.perform(post("/register")
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testLoginReturnsJwt() throws Exception {
        LoginDto dto = new LoginDto("username", "password");
        MvcResult result = mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andReturn();
        String json = result.getResponse().getContentAsString();
        String jwt = objectMapper.readTree(json).get("token").asText();

        assertNotNull(jwt);
        assertFalse(jwt.isEmpty());

        mockMvc.perform(get("/profile")
                .header("Authorization", "Bearer "+jwt))
                .andExpect(status().isOk());
    }
}
