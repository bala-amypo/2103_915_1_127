package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Complaint {

    public enum Status { NEW, OPEN, IN_PROGRESS, RESOLVED }
    public enum Severity { LOW, MEDIUM, HIGH, CRITICAL }
    public enum Urgency { LOW, MEDIUM, HIGH, IMMEDIATE }

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

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @ManyToOne
    private User customer;

    @ManyToOne
    private User assignedAgent;

    private LocalDateTime createdAt;

    /* 🔥 THIS IS THE KEY FIX */
    @ManyToMany
    private List<PriorityRule> priorityRules = new ArrayList<>();

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // ===== setters =====
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setChannel(String channel) { this.channel = channel; }
    public void setSeverity(Severity severity) { this.severity = severity; }
    public void setUrgency(Urgency urgency) { this.urgency = urgency; }
    public void setCustomer(User customer) { this.customer = customer; }
    public void setAssignedAgent(User assignedAgent) { this.assignedAgent = assignedAgent; }
    public void setStatus(Status status) { this.status = status; }
    public void setPriorityScore(Integer priorityScore) { this.priorityScore = priorityScore; }

    public void setPriorityRules(List<PriorityRule> priorityRules) {
        this.priorityRules = priorityRules;
    }

    // ===== getters =====
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public User getCustomer() { return customer; }
    public User getAssignedAgent() { return assignedAgent; }
    public Integer getPriorityScore() { return priorityScore; }
    public Status getStatus() { return status; }
    public Severity getSeverity() { return severity; }
    public Urgency getUrgency() { return urgency; }

    /* 🔥 REQUIRED BY TEST */
    public List<PriorityRule> getPriorityRules() {
        return priorityRules;
    }
}
