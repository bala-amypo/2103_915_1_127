package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public ResponseEntity<Complaint> submitComplaint(
            @RequestBody ComplaintRequest request) {

        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());

        // ✅ FIX: set userId (NOT User object)
        complaint.setUserId(request.getUserId());

        // ✅ String → Enum conversion
        complaint.setSeverity(
                Complaint.Severity.valueOf(
                        request.getSeverity().toUpperCase()
                )
        );

        complaint.setUrgency(
                Complaint.Urgency.valueOf(
                        request.getUrgency().toUpperCase()
                )
        );

        Complaint saved = complaintService.submitComplaint(complaint);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/prioritized")
    public ResponseEntity<?> getPrioritizedComplaints() {
        return ResponseEntity.ok(
                complaintService.getPrioritizedComplaints()
        );
    }
}
