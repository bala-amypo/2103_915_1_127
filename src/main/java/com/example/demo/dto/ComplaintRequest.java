package com.example.demo.dto;

import com.example.demo.entity.Complaint;

public class ComplaintRequest {

    private String title;
    private String description;
    private String category;
    private String channel;
    private Complaint.Severity severity;
    private Complaint.Urgency urgency;

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

    public Complaint.Severity getSeverity() {
        return severity;
    }

    public Complaint.Urgency getUrgency() {
        return urgency;
    }
}
