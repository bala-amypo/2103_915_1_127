package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // ✅ TEST EXPECTS THIS CONSTRUCTOR
    public UserServiceImpl(UserRepository repo,
                           PasswordEncoder encoder) {
        this.userRepository = repo;
        this.passwordEncoder = encoder;
    }

    // ==============================
    // Existing
    // ==============================
    @Override
    public User registerUser(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return userRepository.save(u);
    }

    // ==============================
    // REQUIRED BY AuthController
    // ==============================
    @Override
    public User registerCustomer(String email, String password, String role) {
        User u = new User();
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        u.setRole(role);
        return userRepository.save(u);
    }

    // ==============================
    // REQUIRED BY ComplaintController
    // ==============================
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
