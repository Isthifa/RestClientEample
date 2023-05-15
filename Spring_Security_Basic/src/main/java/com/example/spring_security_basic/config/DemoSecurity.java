package com.example.spring_security_basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Locale;

@Configuration
public class DemoSecurity {
    @Bean
    public InMemoryUserDetailsManager UserDetailsManger()
    {
        UserDetails user1= User.builder()
                .username("user1")
                .password("{noop}user1")
                .roles("Employee")
                .build();
        UserDetails user2=User.builder()
                .username("user2")
                .password("{noop}user2")
                .roles("Employee","Admin")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(configurer->configurer
                .requestMatchers(HttpMethod.GET,"/hello").hasRole("Employee")
                .requestMatchers(HttpMethod.GET,"/hello").hasRole("Admin")
                .requestMatchers(HttpMethod.GET,"/admin").hasRole("Admin")
        );
        http.httpBasic();
        http.csrf().disable();
        return http.build();


    }
}
