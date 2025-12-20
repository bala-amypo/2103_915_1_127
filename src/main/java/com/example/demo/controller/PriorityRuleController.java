package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    @GetMapping
    public String getRules() {
        return "rules";
    }
}
