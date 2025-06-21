package com.example.demo.adapter.out.user;

import com.example.demo.domain.user.model.User;
import com.example.demo.domain.user.port.UserRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaUserAdapter implements UserRepositoryPort {

    private final SpringDataUserRepository springRepo;

    public JpaUserAdapter(SpringDataUserRepository springRepo) {
        this.springRepo = springRepo;
    }

    @Override
    public void save(User user) {
        springRepo.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return springRepo.findById(id);
    }
    @Override
    public List<User> findAll() {
        return springRepo.findAll();
    }
}
