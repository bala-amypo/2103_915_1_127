package com.example.demo.dto;

public class ComplaintResponse {

    private Long complaintId;
    private Integer priorityScore;
    private String status;

    public ComplaintResponse() {
    }

    public ComplaintResponse(Long complaintId, Integer priorityScore, String status) {
        this.complaintId = complaintId;
        this.priorityScore = priorityScore;
        this.status = status;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Integer getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(Integer priorityScore) {
        this.priorityScore = priorityScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
