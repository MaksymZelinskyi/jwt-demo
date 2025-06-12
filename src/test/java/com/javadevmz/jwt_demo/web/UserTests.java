package com.javadevmz.jwt_demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @PreAuthorize("ADMIN")
    public void testGetUsersRequiresAdminRoleAsAdmin() throws Exception{
        mockMvc.perform(get("admin/users")).andExpect(status().isOk());
    }

    @Test
    @PreAuthorize("TEACHER")
    public void testGetUsersRequiresAdminRoleAsTeacher() throws Exception{
        mockMvc.perform(get("admin/users")).andExpect(status().isForbidden());
    }
}
