package com.fitnessapp.fitnessapp.controller;

import com.fitnessapp.fitnessapp.dto.LoginRequest;
import com.fitnessapp.fitnessapp.dto.RegisterRequest;
import com.fitnessapp.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
