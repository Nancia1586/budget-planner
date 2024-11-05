package com.project.budget_planner.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private static final String[] SWAGGER_WHITELIST = {
        "/swagger-ui/**",
        "/v3/api-docs/**",
        "/swagger-resources/**",
        "/swagger-resources"
    };

    private static final String[] PUBLIC_POST_APIS = {
        "/users"
    };

    private static final String[] PUBLIC_GET_APIS = {
        "/users"
    };

    private static final String[] PUBLIC_PUT_APIS = {
        
    };

    private static final String[] PUBLIC_DELETE_APIS = {
        
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/public/**").permitAll()
            .requestMatchers(SWAGGER_WHITELIST).permitAll()
            .requestMatchers(HttpMethod.POST, PUBLIC_POST_APIS).permitAll() // POST api autorisés
            .requestMatchers(HttpMethod.GET, PUBLIC_GET_APIS).permitAll()  // GET api autorisés
            .requestMatchers(HttpMethod.PUT, PUBLIC_PUT_APIS).permitAll()  // PUT api autorisés
            .requestMatchers(HttpMethod.DELETE, PUBLIC_DELETE_APIS).permitAll()  // DELETE api autorisés
            .anyRequest().authenticated() // Les autres nécessitent une authentification
        )
        .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
