package com.Lamsa.controller;

import com.Lamsa.entity.User;
import com.Lamsa.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User request) {

        Optional<User> user = userRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(request.getEmail())
                        && u.getPassword().equals(request.getPassword()))
                .findFirst();

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }
}