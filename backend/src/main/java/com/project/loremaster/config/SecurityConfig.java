package com.project.loremaster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .cors()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/users/get", "/users/add", "/users/setscore", "/users/getleaders", "/question/get")
                .permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/**").authenticated()
                .and()
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
                .and()
                .authenticationProvider(authenticationProvider)
                ;


        return http.build();
    }
}
