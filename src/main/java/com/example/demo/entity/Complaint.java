package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Complaint {

    // ===== ENUMS =====
    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, MEDIUM, HIGH
    }

    public enum Status {
        OPEN, IN_PROGRESS, RESOLVED, CLOSED
    }

    // ===== FIELDS =====
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;          // ✅ REQUIRED BY TESTS
    private String description;

    private String category;
    private String channel;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;

    private int priorityScore = 0;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private User customer;

    @ManyToMany
    @JoinTable(
        name = "complaint_priority_rule",
        joinColumns = @JoinColumn(name = "complaint_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private List<PriorityRule> priorityRules = new ArrayList<>();

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {        // ✅ tests use setId()
        this.id = id;
    }

    public String getTitle() {           // ✅ REQUIRED
        return title;
    }

    public void setTitle(String title) { // ✅ REQUIRED
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { // ✅ REQUIRED
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) { // ✅ REQUIRED
        this.category = category;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) { // ✅ REQUIRED
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

    // ✅ TESTS COMPARE STRING VALUES
    public String getSeverityValue() {
        return severity != null ? severity.name() : null;
    }

    public String getUrgencyValue() {
        return urgency != null ? urgency.name() : null;
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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) { // ✅ REQUIRED
        this.customer = customer;
    }

    public List<PriorityRule> getPriorityRules() { // ✅ REQUIRED
        return priorityRules;
    }

    public void setPriorityRules(List<PriorityRule> priorityRules) {
        this.priorityRules = priorityRules;
    }
}
