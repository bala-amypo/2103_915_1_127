package com.example.demo.dto;

import com.example.demo.entity.Severity;
import com.example.demo.entity.Urgency;

public class ComplaintRequest {

    private Long userId;        // 🔥 REQUIRED
    private String title;
    private String description;
    private Severity severity;
    private Urgency urgency;

    // ----- GETTERS -----

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    // ----- SETTERS -----

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }
}
