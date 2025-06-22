package com.example.demo.domain.user.port;

public interface PasswordHasher {
    String hash(String plainPassword);
    boolean matches(String plainPassword, String hashedPassword);
}