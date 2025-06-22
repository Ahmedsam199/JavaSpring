package com.example.demo.domain.user.port;

public interface JWTService {
    String generateToken(String userId);
    boolean isValid(String token);
    String extractUserId(String token);
}
