package com.javadevmz.jwt_demo.controller.impl;

import com.javadevmz.jwt_demo.model.User;
import com.javadevmz.jwt_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements com.javadevmz.jwt_demo.controller.UserController {

    private final UserService service;

    @Override
    @GetMapping("/profile")
    public User getProfile() {
        return service.getProfile();
    }

    @Override
    @GetMapping("/admin/users")
    public List<User> getUsers() {
        return service.getUsers();
    }
}
