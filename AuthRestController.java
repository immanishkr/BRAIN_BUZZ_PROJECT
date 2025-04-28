package com.quizapp.controller;

import com.quizapp.model.User;
import com.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // Allow frontend requests
public class AuthRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        boolean registered = userService.register(user);
        return registered ? "success" : "taken";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        boolean loggedIn = userService.login(user.getUsername(), user.getPassword());
        return loggedIn ? "success" : "fail";
    }
}
