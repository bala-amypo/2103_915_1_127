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

    @PostMapping("/submit")
    public ComplaintResponse submitComplaint(@RequestBody ComplaintRequest request) {

        User user = userService.findById(1L);

        Complaint complaint = complaintService.submitComplaint(request, user);

        // ✅ FIXED constructor order
        return new ComplaintResponse(
                complaint.getId(),
                complaint.getPriorityScore(),
                complaint.getStatus().name()
        );
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> getUserComplaints(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return complaintService.getComplaintsForUser(user);
    }

    @GetMapping("/prioritized")
    public List<Complaint> getPrioritizedComplaints() {
        return complaintService.getPrioritizedComplaints();
    }

    @PutMapping("/status/{id}")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam String status) {
        complaintService.updateStatus(id, status);
        return "Status updated successfully";
    }
}
