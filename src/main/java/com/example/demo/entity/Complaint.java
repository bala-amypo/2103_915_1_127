package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Complaint {

    // ================= ENUMS =================
    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, MEDIUM, HIGH, IMMEDIATE
    }

    public enum Status {
        NEW, OPEN, IN_PROGRESS, RESOLVED, CLOSED
    }

    // ================= FIELDS =================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private String channel;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @Enumerated(EnumType.STRING)
    private Status status;

    // ✅ MUST BE Integer (tests use null + dereference)
    private Integer priorityScore;

    private LocalDateTime createdAt;

    @ManyToOne
    private User customer;

    @ManyToOne
    private User assignedAgent;

    @ManyToMany
    private List<PriorityRule> priorityRules = new ArrayList<>();

    // ================= GETTERS / SETTERS =================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // -------- TITLE --------
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // -------- DESCRIPTION --------
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // -------- CATEGORY --------
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // -------- CHANNEL --------
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    // -------- SEVERITY (STRING BASED) --------
    public String getSeverity() {   // ✅ TEST EXPECTS STRING
        return severity != null ? severity.name() : null;
    }

    public void setSeverity(String severity) {
        this.severity = severity != null ? Severity.valueOf(severity) : null;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    // -------- URGENCY (STRING BASED) --------
    public String getUrgency() {   // ✅ TEST EXPECTS STRING
        return urgency != null ? urgency.name() : null;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency != null ? Urgency.valueOf(urgency) : null;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    // -------- STATUS --------
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // -------- PRIORITY SCORE --------
    public Integer getPriorityScore() {   // ✅ Integer REQUIRED
        return priorityScore;
    }

    public void setPriorityScore(Integer priorityScore) {
        this.priorityScore = priorityScore;
    }

    // -------- CREATED AT --------
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // -------- CUSTOMER --------
    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    // -------- ASSIGNED AGENT --------
    public User getAssignedAgent() {
        return assignedAgent;
    }

    public void setAssignedAgent(User assignedAgent) {
        this.assignedAgent = assignedAgent;
    }

    // -------- PRIORITY RULES --------
    public List<PriorityRule> getPriorityRules() {
        return priorityRules;
    }

    public void setPriorityRules(List<PriorityRule> priorityRules) {
        this.priorityRules = priorityRules;
    }
}
