package com.example.demo.domain.user.port;

import com.example.demo.domain.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    void save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
}
