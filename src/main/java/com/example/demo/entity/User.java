package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public enum Role {
        CUSTOMER,
        AGENT,
        ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // controller/service use BOTH name & fullName
    private String name;
    private String fullName;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // ===== getters & setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // REQUIRED by UserServiceImpl
    public String getName() {
        return name;
    }

    public void setName(String name) {   // 🔥 FIX
        this.name = name;
        this.fullName = name; // keep both in sync
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        this.name = fullName;
    }

    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public Role getRole() {
        return role;
    }
 
    public void setRole(Role role) {
        this.role = role;
    }
}
