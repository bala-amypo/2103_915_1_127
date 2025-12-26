package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private String channel;

    // Stored as STRING (tests + services expect this)
    private String severity;
    private String urgency;

    // ⭐ REQUIRED FOR TESTS
    private Integer priorityScore;

    @Enumerated(EnumType.STRING)
    private Status status;

    // ===== RELATIONS =====

    @ManyToOne
    private User customer;

    @ManyToOne
    private User assignedAgent;

    @ManyToMany
    private List<PriorityRule> priorityRules = new ArrayList<>();

    // ===== ENUMS =====

    public enum Severity {
        CRITICAL,
        HIGH,
        MEDIUM,
        LOW
    }

    public enum Urgency {
        IMMEDIATE,
        HIGH,
        MEDIUM,
        LOW
    }

    public enum Status {
        NEW,
        ASSIGNED,
        IN_PROGRESS,
        RESOLVED
    }

    // ===== CONSTRUCTORS =====

    public Complaint() {
        this.status = Status.NEW;
    }

    // ✅ TESTS USE THIS (ENUM INPUT)
    public Complaint(String title,
                     String description,
                     String category,
                     String channel,
                     Severity severity,
                     Urgency urgency) {

        this.title = title;
        this.description = description;
        this.category = category;
        this.channel = channel;
        this.severity = severity.name();
        this.urgency = urgency.name();
        this.status = Status.NEW;
    }

    // ✅ SERVICES USE THIS (STRING INPUT)
    public Complaint(String title,
                     String description,
                     String category,
                     String channel,
                     String severity,
                     String urgency) {

        this.title = title;
        this.description = description;
        this.category = category;
        this.channel = channel;
        this.severity = severity;
        this.urgency = urgency;
        this.status = Status.NEW;
    }

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getChannel() {
        return channel;
    }

    public String getSeverity() {
        return severity;
    }

    public String getUrgency() {
        return urgency;
    }

    public Status getStatus() {
        return status;
    }

    public User getCustomer() {
        return customer;
    }

    public User getAssignedAgent() {
        return assignedAgent;
    }

    public List<PriorityRule> getPriorityRules() {
        return priorityRules;
    }

    // ⭐ TESTS REQUIRE THIS
    public Integer getPriorityScore() {
        return priorityScore;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    // STRING setters
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    // ENUM setters (TESTS USE THIS)
    public void setSeverity(Severity severity) {
        this.severity = severity.name();
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency.name();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setAssignedAgent(User assignedAgent) {
        this.assignedAgent = assignedAgent;
    }

    public void setPriorityRules(List<PriorityRule> priorityRules) {
        this.priorityRules = priorityRules;
    }

    // ⭐ TESTS REQUIRE THIS (null-um accept pannum)
    public void setPriorityScore(Integer priorityScore) {
        this.priorityScore = priorityScore;
    }
}
