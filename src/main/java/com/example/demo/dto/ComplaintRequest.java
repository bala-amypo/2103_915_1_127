package com.example.demo.dto;

public class ComplaintRequest {

    private Long userId;
    private String title;
    private String description;

    // ✅ ENUM-ah illa → String
    private String severity;
    private String urgency;

    // ---------- GETTERS ----------

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public String getUrgency() {
        return urgency;
    }

    // ---------- SETTERS ----------

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
}
