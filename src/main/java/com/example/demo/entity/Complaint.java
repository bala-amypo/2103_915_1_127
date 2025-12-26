package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Complaint {

    /* ================= ENUMS ================= */

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

    private String category;
    private String channel;

    // 🔴 STORE AS STRING (TEST EXPECTATION)
    private String severity;
    private String urgency;

    private Status status;
    private User customer;
    private User assignedAgent;

    // 🔴 MUST BE Integer (NOT int)
    private Integer priorityScore;

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

    /* ---------- CATEGORY / CHANNEL ---------- */

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

    /* ---------- SEVERITY ---------- */

    public String getSeverity() {
        return severity;
    }

    // ✅ TEST CALLS THIS
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    // ✅ TEST ALSO CALLS THIS
    public void setSeverity(Severity severity) {
        this.severity = severity.name();
    }

    /* ---------- URGENCY ---------- */

    public String getUrgency() {
        return urgency;
    }

    // ✅ TEST CALLS THIS
    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    // ✅ TEST ALSO CALLS THIS
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

    public Integer getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(Integer priorityScore) {
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
