package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class User {

    public enum Role { CUSTOMER, AGENT, ADMIN }

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String fullName;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User u)) return false;
        return Objects.equals(id, u.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
