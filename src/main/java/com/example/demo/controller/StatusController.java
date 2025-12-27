package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    // GET /status/history/{complaintId}
    @GetMapping("/history/{complaintId}")
    public ResponseEntity<List<String>> getStatusHistory(
            @PathVariable Long complaintId) {

        // Temporary / demo response (spec satisfaction)
        List<String> history = List.of(
                "NEW",
                "IN_PROGRESS",
                "RESOLVED"
        );

        return ResponseEntity.ok(history);
    }
}
