package com.example.demo.adapter.out.user;

// 📁 src/main/java/com/example/demo/adapter/out/user/SpringDataUserRepository.java


import com.example.demo.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
}
