package com.javadevmz.jwt_demo.service;

import com.javadevmz.jwt_demo.model.User;
import com.javadevmz.jwt_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User getProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null) throw new RuntimeException("Not authenticated");
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return repository.findByUsername(userDetails.getUsername());
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
}
