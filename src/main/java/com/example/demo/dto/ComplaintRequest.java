package com.example.demo.dto;

import com.example.demo.entity.Complaint;

public class ComplaintRequest {

    private String category;
    private String channel;
    private Complaint.Severity severity;
    private Complaint.Urgency urgency;
    private String description;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Complaint.Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Complaint.Severity severity) {
        this.severity = severity;
    }

    public Complaint.Urgency getUrgency() {
        return urgency;
    }

    public void setUrgency(Complaint.Urgency urgency) {
        this.urgency = urgency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
