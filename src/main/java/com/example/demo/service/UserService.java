package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    // already used
    User registerUser(User user);

    // ✅ REQUIRED BY AuthController
    User registerCustomer(String email, String password, String role);

    // ✅ REQUIRED BY ComplaintController
    User findByEmail(String email);
}
