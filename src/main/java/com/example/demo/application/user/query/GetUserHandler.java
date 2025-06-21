package com.example.demo.application.user.query;

import com.example.demo.domain.user.model.User;
import com.example.demo.domain.user.port.UserRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class GetUserHandler {
    private final UserRepositoryPort repo;

    public GetUserHandler(UserRepositoryPort repo) {
        this.repo = repo;
    }

    public User handle(GetUserQuery query) {
        return repo.findById(query.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
