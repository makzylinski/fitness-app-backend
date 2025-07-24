package com.fitnessapp.fitnessapp.service;

import com.fitnessapp.fitnessapp.dto.LoginRequest;
import com.fitnessapp.fitnessapp.dto.LoginResponse;
import com.fitnessapp.fitnessapp.dto.RegisterRequest;
import com.fitnessapp.fitnessapp.model.Role;
import com.fitnessapp.fitnessapp.model.User;
import com.fitnessapp.fitnessapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public void register(RegisterRequest request) {
        if (request.getEmail() == null || request.getPassword() == null) {
            throw new RuntimeException("Email and password must not be null");
        }

        userRepository.findByEmail(request.getEmail())
                .ifPresent(user -> {
                    throw new RuntimeException("User with this email already exists");
                });

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        userRepository.save(new User(request.getEmail(), encodedPassword, Role.USER));
    }

    public LoginResponse login(LoginRequest loginRequest) {
       User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new RuntimeException("User with this email does not exist")
        );

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new LoginResponse(
                jwtService.generateToken(user),
                "Login successful"
        );
    }
}
