package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String channel;
    private int priorityScore;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @ManyToOne
    private User user;

    public enum Severity {
        LOW, MEDIUM, HIGH
    }

    public enum Urgency {
        LOW, MEDIUM, HIGH
    }

    // getters & setters
}
