package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    private User customer;

    @ManyToOne
    private User assignedAgent;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @Enumerated(EnumType.STRING)
    private Status status;

    private int priorityScore;

    private LocalDateTime createdAt;

    @ManyToMany
    private List<PriorityRule> priorityRules = new ArrayList<>();

    /* ===== ENUMS (TEST EXPECTED VALUES) ===== */

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, NORMAL, HIGH, IMMEDIATE
    }

    public enum Status {
        NEW, OPEN, IN_PROGRESS, RESOLVED
    }

    /* ===== GETTERS & SETTERS ===== */

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getCustomer() { return customer; }
    public void setCustomer(User customer) { this.customer = customer; }

    public User getAssignedAgent() { return assignedAgent; }
    public void setAssignedAgent(User assignedAgent) { this.assignedAgent = assignedAgent; }

    public Severity getSeverity() { return severity; }
    public void setSeverity(Severity severity) { this.severity = severity; }

    public Urgency getUrgency() { return urgency; }
    public void setUrgency(Urgency urgency) { this.urgency = urgency; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public int getPriorityScore() { return priorityScore; }
    public void setPriorityScore(int priorityScore) { this.priorityScore = priorityScore; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<PriorityRule> getPriorityRules() { return priorityRules; }
}
