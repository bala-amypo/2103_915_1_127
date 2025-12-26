package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String email;
    private String role;

    public AuthResponse() {
    }

    // Existing constructor (keep)
    public AuthResponse(String token, String email, Long userId) {
        this.token = token;
        this.email = email;
        this.userId = userId;
    }

    // Required for STEP-5 controllers
    public AuthResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
