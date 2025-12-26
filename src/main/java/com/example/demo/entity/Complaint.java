package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Complaint {

    public enum Status {
        NEW, OPEN, IN_PROGRESS, RESOLVED
    }

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, MEDIUM, HIGH, IMMEDIATE
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

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    private LocalDateTime createdAt;

    @ManyToMany
    private Set<PriorityRule> priorityRules = new HashSet<>();

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public Integer getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(Integer priorityScore) {
        this.priorityScore = priorityScore;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public Set<PriorityRule> getPriorityRules() {
        return priorityRules;
    }
}
