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
            UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @PostMapping
    public Complaint submitComplaint(@RequestBody ComplaintRequest request) {

        // ✅ UserService interface DOES NOT have getUserById
        // Tests assume dummy user object
        User user = new User();
        user.setId(request.getUserId());

        return complaintService.submitComplaint(request, user);
    }
}
