package com.fitnessapp.fitnessapp.service;

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
    private void register(RegisterRequest request) {
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
}
