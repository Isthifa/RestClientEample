package com.example.spring_security_basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class examplerest {
    @GetMapping("/hello")
    public String sayhello()
    {
        return "Good morning";
    }
    @GetMapping("/admin")
    public String admin()
    {
        return "Hello Admin";
    }
}
