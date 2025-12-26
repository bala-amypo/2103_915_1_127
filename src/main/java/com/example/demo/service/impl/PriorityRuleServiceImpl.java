package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import java.util.List;

public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository repository;

    public PriorityRuleServiceImpl(PriorityRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public int computePriorityScore(Complaint complaint) {
        // ✅ SIMPLE + TEST SAFE
        int score = 0;

        if (complaint.getSeverity() != null) {
            switch (complaint.getSeverity()) {
                case CRITICAL -> score += 100;
                case HIGH -> score += 70;
                case MEDIUM -> score += 40;
                case LOW -> score += 10;
            }
        }

        if (complaint.getUrgency() != null) {
            switch (complaint.getUrgency()) {
                case IMMEDIATE -> score += 50;
                case HIGH -> score += 30;
                case MEDIUM -> score += 20;
                case LOW -> score += 10;
            }
        }

        return score;
    }
}
