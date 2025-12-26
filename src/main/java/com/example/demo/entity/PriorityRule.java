package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int weight;
    private boolean active = true;

    @ManyToMany(mappedBy = "priorityRules")
    private List<Complaint> complaints = new ArrayList<>();

    /* ===== GETTERS & SETTERS (TEST REQUIRED) ===== */

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public boolean isActive() { return active; }

    public List<Complaint> getComplaints() { return complaints; }
}
