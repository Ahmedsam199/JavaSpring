package com.example.demo.application.user.query;

import com.example.demo.domain.user.model.User;
import com.example.demo.domain.user.port.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GetAllUsersHandler {

    private final UserRepositoryPort repo;

    // Constructor must assign repo to the field!
    public GetAllUsersHandler(UserRepositoryPort repo) {
        this.repo = repo;  // <-- This line initializes the field
    }

    public List<User> handle(GetAllUsersQuery query) {
        return repo.findAll();
    }
}

