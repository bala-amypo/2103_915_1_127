package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusController {

    /**
     * GET /status/history/{complaintId}
     * Get status history of a complaint
     */
    @GetMapping("/history/{complaintId}")
    public String getStatusHistory(@PathVariable Long complaintId) {
        // Placeholder implementation (as per STEP-5 spec)
        return "Status history for complaint id: " + complaintId;
    }
}
