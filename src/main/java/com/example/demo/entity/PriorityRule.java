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

    // 🔥 REQUIRED by PriorityRuleServiceImpl
    public void apply(Complaint complaint) {
        if (!active) return;

        complaint.setPriorityScore(
            complaint.getPriorityScore() + this.weight
        );

        if (!complaint.getPriorityRules().contains(this)) {
            complaint.getPriorityRules().add(this);
        }

        if (!complaints.contains(complaint)) {
            complaints.add(complaint);
        }
    }

    // ===== getters & setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
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

    public List<Complaint> getComplaints() {
        return complaints;
    }
}
