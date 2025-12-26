package com.example.demo.entity;

import java.time.LocalDateTime;

public class Complaint {

    public enum Severity {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum Urgency {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum Status {
        NEW,
        IN_PROGRESS,
        RESOLVED
    }

    private Long id;
    private String title;
    private String description;
    private String category;
    private String channel;
    private Severity severity;
    private Urgency urgency;
    private Status status;
    private int priorityScore;
    private User customer;
    private LocalDateTime createdAt;

    public Complaint() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }

    public Severity getSeverity() { return severity; }
    public void setSeverity(Severity severity) { this.severity = severity; }

    public Urgency getUrgency() { return urgency; }
    public void setUrgency(Urgency urgency) { this.urgency = urgency; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public int getPriorityScore() { return priorityScore; }
    public void setPriorityScore(int priorityScore) { this.priorityScore = priorityScore; }

    public User getCustomer() { return customer; }
    public void setCustomer(User customer) { this.customer = customer; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
