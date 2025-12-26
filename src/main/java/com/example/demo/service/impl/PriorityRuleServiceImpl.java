package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

public class PriorityRuleServiceImpl implements PriorityRuleService {

    private PriorityRuleRepository repository;

    public PriorityRuleServiceImpl(PriorityRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public int calculatePriorityScore(Complaint complaint) {
        int score = 0;
        for (PriorityRule rule : complaint.getPriorityRules()) {
            score += rule.getWeight();
        }
        return score;
    }
}
