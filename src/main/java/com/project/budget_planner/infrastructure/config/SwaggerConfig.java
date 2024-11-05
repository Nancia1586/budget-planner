package com.project.budget_planner.infrastructure.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
    
    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("public-apis")
            .pathsToMatch("/**")
            .build();
    }

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Budget Planner API docs").version("API v1"))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(
                new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")));
            
    }
}