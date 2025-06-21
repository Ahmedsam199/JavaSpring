package com.example.demo.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserReposirty extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);

}
