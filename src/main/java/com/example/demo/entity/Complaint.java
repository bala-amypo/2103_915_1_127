package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Complaint {

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, NORMAL, HIGH, IMMEDIATE
    }

    public enum Status {
        NEW, IN_PROGRESS, RESOLVED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private String channel;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    private int priorityScore;

    @ManyToOne
    private User customer;

    @ManyToOne
    private User assignedAgent;

    @ManyToMany
    @JoinTable(
        name = "complaint_priority_rules",
        joinColumns = @JoinColumn(name = "complaint_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private List<PriorityRule> priorityRules = new ArrayList<>();

    // ===== getters & setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) { // tests need this
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) { // tests need this
        this.category = category;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) { // tests need this
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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getAssignedAgent() {
        return assignedAgent;
    }

    public void setAssignedAgent(User assignedAgent) { // tests need this
        this.assignedAgent = assignedAgent;
    }

    public List<PriorityRule> getPriorityRules() { // tests need this
        return priorityRules;
    }

    public void setPriorityRules(List<PriorityRule> priorityRules) {
        this.priorityRules = priorityRules;
    }
}
