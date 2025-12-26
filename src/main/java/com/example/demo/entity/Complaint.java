package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Complaint {

    // ===== ENUMS (TESTS EXPECT THESE VALUES) =====

    public enum Severity {
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }

    public enum Urgency {
        LOW,
        MEDIUM,
        HIGH,
        IMMEDIATE
    }

    public enum Status {
        NEW,
        IN_PROGRESS,
        RESOLVED,
        CLOSED
    }

    // ===== FIELDS =====

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String category;

    private String channel;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    private int priorityScore;

    private LocalDateTime createdAt = LocalDateTime.now();

    // ===== RELATIONSHIPS =====

    @ManyToOne
    private User customer;

    @ManyToOne
    private User assignedAgent;

    @ManyToMany
    private List<PriorityRule> priorityRules = new ArrayList<>();

    // ===== GETTERS & SETTERS (ALL REQUIRED BY TESTS) =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {           // ✅ TESTS USE setId()
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(int priorityScore) {
        this.priorityScore = priorityScore;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getCustomer() {             // ✅ REQUIRED
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getAssignedAgent() {         // ✅ REQUIRED
        return assignedAgent;
    }

    public void setAssignedAgent(User assignedAgent) {
        this.assignedAgent = assignedAgent;
    }

    public List<PriorityRule> getPriorityRules() {   // ✅ CRITICAL
        return priorityRules;
    }
}
