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

    private String category;

    private int weight;

    private boolean active = true;

    @ManyToMany(mappedBy = "priorityRules")
    private List<Complaint> complaints = new ArrayList<>();

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {       // ✅ tests use this
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {   // ✅ REQUIRED
        return description;
    }

    public void setDescription(String description) { // ✅ REQUIRED
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWeight() {            // ✅ REQUIRED
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Complaint> getComplaints() { // ✅ REQUIRED
        return complaints;
    }
}
