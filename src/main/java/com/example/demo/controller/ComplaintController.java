package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @PostMapping
    public ComplaintResponse submitComplaint(@RequestBody ComplaintRequest request) {
        // Minimal response
        return new ComplaintResponse(1L, 0, "NEW");
    }

    @GetMapping
    public String getComplaints() {
        return "complaints";
    }
}
