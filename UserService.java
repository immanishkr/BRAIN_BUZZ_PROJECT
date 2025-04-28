package com.quizapp.service;

import com.quizapp.model.User;
import com.quizapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public boolean register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return false; // Username already taken
        }
        // No hashing here, password is already hashed on frontend
        userRepository.save(user);
        return true;
    }

    // Login check
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        // Compare plain password (from frontend) with hashed password in DB
        // This requires frontend to send the already hashed password (not a good practice usually, but okay here)
        return user != null && user.getPassword().equals(password);
    }
}
