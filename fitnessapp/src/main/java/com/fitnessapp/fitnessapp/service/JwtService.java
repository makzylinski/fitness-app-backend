package com.fitnessapp.fitnessapp.service;

import com.fitnessapp.fitnessapp.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
@Service
public class JwtService {
    private static final String SECRET_KEY = "sekret1234567890sekret1234567890"; // TODO move to configs

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole().name())
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
