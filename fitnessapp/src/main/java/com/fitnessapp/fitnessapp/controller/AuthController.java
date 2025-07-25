package com.fitnessapp.fitnessapp.controller;

import com.fitnessapp.fitnessapp.dto.*;
import com.fitnessapp.fitnessapp.model.User;
import com.fitnessapp.fitnessapp.repository.UserRepository;
import com.fitnessapp.fitnessapp.service.JwtService;
import com.fitnessapp.fitnessapp.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        try {
            userService.register(registerRequest);
            return ResponseEntity.ok(new RegisterResponse("User registered successfully"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new RegisterResponse(e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        try {
            String token = userService.login(loginRequest);

            Cookie cookie = new Cookie("jwt", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60);

            response.addCookie(cookie);

            return ResponseEntity.ok(new LoginResponse("Login successful"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new LoginResponse(e.getMessage()));
        }
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse>getCurrentUser(HttpServletRequest request) {
        String token = jwtService.extractTokenFromCookie(request);
        if (token == null) {
            return ResponseEntity.status(401).body(new UserResponse("Unauthorized"));
        }

        String email = jwtService.extractEmailFromToken(token);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserResponse userResponse = new UserResponse(
                user.getEmail(),
                user.getRole().name(),
                "User details retrieved successfully"
        );
        return ResponseEntity.ok(userResponse);
    }
}
