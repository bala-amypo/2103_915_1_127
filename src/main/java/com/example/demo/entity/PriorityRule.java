package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private int weight;
    private boolean active;

    // ===== REQUIRED BY TESTS =====
    public int apply(Complaint complaint) {
        return weight;
    }

    // getters & setters
    public boolean isActive() {
        return active;
    }
}
