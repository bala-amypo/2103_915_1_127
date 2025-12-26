package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Complaint {

    public enum Status {
        NEW, OPEN, IN_PROGRESS, RESOLVED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private String channel;

    private Integer priorityScore;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ✅ REQUIRED SETTER (FIX)
    public void setStatus(Status status) {
        this.status = status;
    }

    // getters
    public Long getId() { return id; }
    public Integer getPriorityScore() { return priorityScore; }
    public Status getStatus() { return status; }
}
