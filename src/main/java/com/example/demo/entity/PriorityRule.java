package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String description;

    private int weight;

    private boolean active;

    @ManyToMany(mappedBy = "priorityRules")
    private List<Complaint> complaints = new ArrayList<>();

    // ===== getters & setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) { // tests need this
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) { // tests need this
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { // tests need this
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) { // tests need this
        this.weight = weight;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) { // tests need this
        this.active = active;
    }

    public List<Complaint> getComplaints() { // tests need this
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }
}
