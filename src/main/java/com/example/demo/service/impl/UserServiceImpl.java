package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    // 🔴 TEST EXPECTED CONSTRUCTOR
    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.userRepository = repo;
        this.passwordEncoder = encoder;
    }

    // 🔴 REQUIRED BY INTERFACE
    @Override
    public User registerCustomer(String name, String email, String password) {
        User u = new User();
        u.setFullName(name);
        u.setEmail(email);
        u.setPassword(passwordEncoder != null ? passwordEncoder.encode(password) : password);
        return userRepository != null ? userRepository.save(u) : u;
    }

    // 🔴 INTERFACE RETURNS User (NOT Optional)
    @Override
    public User findByEmail(String email) {
        return userRepository != null ? userRepository.findByEmail(email).orElse(null) : null;
    }
}
