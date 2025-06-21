package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserReposirty userReposirty;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserReposirty userReposirty) {
        this.userReposirty = userReposirty;
    }
public User createUser(User user){
        String encryptedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
    return this.userReposirty.save(user);
}
}
