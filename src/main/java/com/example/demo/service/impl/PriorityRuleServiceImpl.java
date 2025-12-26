package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

import java.util.Collections;
import java.util.List;

public class PriorityRuleServiceImpl implements PriorityRuleService {

    private PriorityRuleRepository priorityRuleRepository;

    // ✅ REQUIRED BY TESTS
    public PriorityRuleServiceImpl(PriorityRuleRepository repo) {
        this.priorityRuleRepository = repo;
    }

    // ================= TEST EXPECTED METHOD =================
    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository != null
                ? priorityRuleRepository.findByActiveTrue()
                : Collections.emptyList();
    }

    // ================= TEST EXPECTED METHOD =================
    @Override
    public int computePriorityScore(Complaint complaint) {

        int score = 0;

        // ---------- SEVERITY ----------
        if (complaint.getSeverity() != null) {
            switch (Complaint.Severity.valueOf(complaint.getSeverity())) {
                case CRITICAL -> score += 50;
                case HIGH -> score += 40;
                case MEDIUM -> score += 30;
                case LOW -> score += 20;
            }
        }

        // ---------- URGENCY ----------
        if (complaint.getUrgency() != null) {
            switch (Complaint.Urgency.valueOf(complaint.getUrgency())) {
                case IMMEDIATE -> score += 50;
                case HIGH -> score += 40;
                case MEDIUM -> score += 30;
                case LOW -> score += 20;
            }
        }

        // ---------- RULE WEIGHTS ----------
        if (complaint.getPriorityRules() != null) {
            for (PriorityRule rule : complaint.getPriorityRules()) {
                score += rule.getWeight();
            }
        }

        return score;
    }
}
