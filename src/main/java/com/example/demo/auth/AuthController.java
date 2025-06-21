package com.example.demo.auth;

import com.example.demo.users.User;
import com.example.demo.users.UserReposirty;
import com.example.demo.config.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserReposirty userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findByName(loginRequest.getUsername());

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        User user = userOpt.get();

        boolean matches = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());

        if (!matches) {
            return ResponseEntity.status(401).body("Invalid  password");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getName());

        // Return token in response body
        return ResponseEntity.ok(Map.of("token", token,"username",user.getName()));
    }
}
