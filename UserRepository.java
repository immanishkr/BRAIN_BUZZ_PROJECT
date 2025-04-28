package com.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username); // Check if username exists
}
