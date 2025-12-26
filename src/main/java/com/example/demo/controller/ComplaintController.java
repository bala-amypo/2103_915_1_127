package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
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

    @PostMapping
    public Complaint submitComplaint(@RequestBody ComplaintRequest request) {

        User user = userService.getUserById(request.getUserId());

        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setCustomer(user);

        complaint.setSeverity(
                Complaint.Severity.valueOf(request.getSeverity())
        );
        complaint.setUrgency(
                Complaint.Urgency.valueOf(request.getUrgency())
        );

        return complaintService.submitComplaint(complaint);
    }
}
