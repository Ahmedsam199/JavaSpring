package com.example.demo.adapter.out.user;

import com.example.demo.domain.user.model.User;
import com.example.demo.domain.user.port.PasswordHasher;
import com.example.demo.domain.user.port.UserRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaUserAdapter implements UserRepositoryPort {

    private final SpringDataUserRepository springRepo;
private final PasswordHasher passwordHasher;
    public JpaUserAdapter(SpringDataUserRepository springRepo, PasswordHasher passwordHasher) {
        this.springRepo = springRepo;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordHasher.hash(user.getPassword()));
      return  springRepo.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return springRepo.findById(id);
    }
    @Override
    public List<User> findAll() {
        return springRepo.findAll();
    }
    @Override
    public User findByName(String name){
        return springRepo.findByName(name);
    }
}
