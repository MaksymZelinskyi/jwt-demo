package com.javadevmz.jwt_demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("JWT-demo")
                        .summary("API-documentation for JWT-authentication based web-system")
                        .description("A college web-system with jwt-authentication and three possible roles: STUDENT, TEACHER, ADMIN")
                );
    }
}
