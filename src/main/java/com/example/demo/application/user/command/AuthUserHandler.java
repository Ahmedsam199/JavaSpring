package com.example.demo.application.user.command;

import com.example.demo.adapter.out.user.BCryptPasswordHasher;
import com.example.demo.adapter.out.user.JWTServiceTMP;
import com.example.demo.domain.user.model.Auth;
import com.example.demo.domain.user.model.User;
import com.example.demo.domain.user.port.UserRepositoryPort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthUserHandler {
    private final UserRepositoryPort userRepositoryPort;
private  final JWTServiceTMP jwtServiceTMP;
private BCryptPasswordHasher bCryptPasswordHasher;
    public AuthUserHandler(UserRepositoryPort userRepositoryPort, JWTServiceTMP jwtServiceTMP, BCryptPasswordHasher bCryptPasswordHasher) {
        this.userRepositoryPort = userRepositoryPort;
        this.jwtServiceTMP = jwtServiceTMP;
        this.bCryptPasswordHasher = bCryptPasswordHasher;
    }
    public Auth handle(AuthUserCommand authUserCommand) {
        // 1. Look up user by name
        User user = this.userRepositoryPort.findByName(authUserCommand.name());

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        // 2. Check password
        if (!bCryptPasswordHasher.matches(authUserCommand.password(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
        }

        // 3. Generate JWT
        String token = jwtServiceTMP.generateToken(user.getId().toString());

        // 4. Return Auth DTO
        Auth auth = new Auth(authUserCommand.name(), authUserCommand.password());
        auth.setEmail(user.getEmail());
        auth.setToken(token);

        return auth;
    }

}
