package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User registerCustomer(String name, String email, String password);

    User findByEmail(String email);

    // Required for STEP-5
    User findById(Long id);
}
