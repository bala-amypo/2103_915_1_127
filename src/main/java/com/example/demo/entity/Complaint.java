package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Complaint {

    /* ================= ENUMS (TEST EXPECTS THESE) ================= */

    public enum Severity {
        CRITICAL, HIGH, MEDIUM, LOW
    }

    public enum Urgency {
        IMMEDIATE, HIGH, MEDIUM, LOW
    }

    public enum Status {
        NEW, IN_PROGRESS, RESOLVED, CLOSED
    }

    /* ================= FIELDS ================= */

    private Long id;
    private String title;
    private String description;

    // 🔥 IMPORTANT: STORE AS STRING
    private String severity;
    private String urgency;

    private Status status;
    private User customer;
    private User assignedAgent;

    private int priorityScore;
    private LocalDateTime createdAt;

    private List<PriorityRule> priorityRules = new ArrayList<>();

    /* ================= GETTERS / SETTERS ================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /* ---------- SEVERITY (STRING BACKED, ENUM FRIENDLY) ---------- */

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    // ✅ REQUIRED FOR TESTS
    public void setSeverity(Severity severity) {
        this.severity = severity.name();
    }

    /* ---------- URGENCY (STRING BACKED, ENUM FRIENDLY) ---------- */

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    // ✅ REQUIRED FOR TESTS
    public void setUrgency(Urgency urgency) {
        this.urgency = urgency.name();
    }

    /* ---------- STATUS ---------- */

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /* ---------- USERS ---------- */

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getAssignedAgent() {
        return assignedAgent;
    }

    public void setAssignedAgent(User assignedAgent) {
        this.assignedAgent = assignedAgent;
    }

    /* ---------- PRIORITY ---------- */

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

    /* ---------- PRIORITY RULES ---------- */

    public List<PriorityRule> getPriorityRules() {
        return priorityRules;
    }

    public void setPriorityRules(List<PriorityRule> priorityRules) {
        this.priorityRules = priorityRules;
    }
}
