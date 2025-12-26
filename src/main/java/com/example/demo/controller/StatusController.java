package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusController {

    // GET /status/history/{complaintId}
    @GetMapping("/history/{complaintId}")
    public String getStatusHistory(@PathVariable Long complaintId) {
        return "Status history for complaint id: " + complaintId;
    }
}
