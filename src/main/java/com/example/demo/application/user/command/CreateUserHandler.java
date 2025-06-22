package com.example.demo.application.user.command;

import com.example.demo.domain.user.model.User;
import com.example.demo.domain.user.port.UserRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUserHandler {
    private final UserRepositoryPort repo;

    public CreateUserHandler(UserRepositoryPort repo) {
        this.repo = repo;
    }

    public User handle(CreateUserCommand command) {
        User user = new User(command.name(), command.email(),command.password());
        return repo.save(user);
    }
}
