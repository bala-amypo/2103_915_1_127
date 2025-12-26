package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(
            ComplaintService complaintService,
            UserService userService
    ) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @PostMapping("/submit")
    public Complaint submitComplaint(@RequestBody ComplaintRequest request) {

        User customer = userService.findById(request.getUserId());

        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setSeverity(request.getSeverity());
        complaint.setUrgency(request.getUrgency());
        complaint.setCustomer(customer);

        return complaintService.submitComplaint(complaint);
    }
}
