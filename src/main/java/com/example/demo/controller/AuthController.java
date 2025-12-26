package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // POST /auth/register
    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        User user = userService.registerCustomer(
                "Demo User",
                request.getEmail(),
                request.getPassword()
        );
        return "User registered with id: " + user.getId();
    }

    // POST /auth/login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return new AuthResponse(
                "dummy-jwt-token",
                1L,
                request.getEmail(),
                "CUSTOMER"
        );
    }
}
