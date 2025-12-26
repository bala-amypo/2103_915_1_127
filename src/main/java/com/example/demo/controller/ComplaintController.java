package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService complaintService,
                               UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Complaint> submitComplaint(
            @RequestBody ComplaintRequest request) {

        // 🔹 FIX 1: getUserById() now exists
        User user = userService.getUserById(request.getUserId());

        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        // 🔹 Build Complaint entity properly
        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());

        // 🔹 String → Enum conversion (tests expect this)
        complaint.setSeverity(
                Complaint.Severity.valueOf(request.getSeverity())
        );
        complaint.setUrgency(
                Complaint.Urgency.valueOf(request.getUrgency())
        );

        complaint.setCustomer(user);
        complaint.setStatus(Complaint.Status.OPEN);

        // 🔹 FIX 2: ComplaintService expects Complaint ONLY
        Complaint savedComplaint = complaintService.submitComplaint(complaint);

        return ResponseEntity.ok(savedComplaint);
    }
}
