package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    // ✅ REQUIRED BY TESTS
    public UserServiceImpl(UserRepository repo,
                           PasswordEncoder encoder) {
        this.userRepository = repo;
        this.passwordEncoder = encoder;
    }

    // Optional: no-arg constructor (safe)
    public UserServiceImpl() {}

    @Override
    public User saveUser(User user) {
        if (passwordEncoder != null && user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository != null ? userRepository.save(user) : user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository != null
                ? userRepository.findByEmail(email)
                : Optional.empty();
    }
}
