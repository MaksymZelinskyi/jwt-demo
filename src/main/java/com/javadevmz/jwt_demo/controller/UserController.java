package com.javadevmz.jwt_demo.controller;

import com.javadevmz.jwt_demo.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Tag(name = "User controller",
     description = "Provides endpoints to retrieve the information about users"
)
public interface UserController {

    @Operation(summary = "Returns the current user's profile",
               description = "Retrieves the current user they are signed in. Requires a valid JWT")
    User getProfile();

    @Operation(summary = "Returns the list of users",
               description = "Retrieves all the users from the database. Requires the ADMIN role")
    List<User> getUsers();
}
