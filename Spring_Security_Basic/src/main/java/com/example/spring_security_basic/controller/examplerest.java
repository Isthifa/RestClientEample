package com.example.spring_security_basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class examplerest {
    @RequestMapping("/hello")
    public String sayhello()
    {
        return "Good morning";
    }
}
