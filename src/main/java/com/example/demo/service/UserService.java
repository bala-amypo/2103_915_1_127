package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User findByEmail(String email);

    User registerCustomer(String name, String email, String password);
}
