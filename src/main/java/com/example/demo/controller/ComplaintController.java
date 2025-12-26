package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * POST /complaints/submit
     * Submit a new complaint
     */
    @PostMapping("/submit")
    public ComplaintResponse submitComplaint(@RequestBody ComplaintRequest request) {

        // In real apps, user comes from JWT / security context
        User user = userService.findById(1L);

        Complaint complaint = complaintService.submitComplaint(request, user);

        return new ComplaintResponse(
                complaint.getId(),
                complaint.getStatus().name(),
                complaint.getPriorityScore()
        );
    }

    /**
     * GET /complaints/user/{userId}
     * Get complaints for a specific user
     */
    @GetMapping("/user/{userId}")
    public List<Complaint> getUserComplaints(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return complaintService.getComplaintsForUser(user);
    }

    /**
     * GET /complaints/prioritized
     * Get all prioritized complaints
     */
    @GetMapping("/prioritized")
    public List<Complaint> getPrioritizedComplaints() {
        return complaintService.getPrioritizedComplaints();
    }

    /**
     * PUT /complaints/status/{id}
     * Update complaint status
     */
    @PutMapping("/status/{id}")
    public String updateComplaintStatus(@PathVariable Long id,
                                        @RequestParam String status) {
        complaintService.updateStatus(id, status);
        return "Complaint status updated successfully";
    }
}
