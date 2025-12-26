package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

import java.util.ArrayList;
import java.util.List;

public class PriorityRuleServiceImpl implements PriorityRuleService {

    private PriorityRuleRepository repository;

    // ✅ REQUIRED BY TEST
    public PriorityRuleServiceImpl(PriorityRuleRepository repository) {
        this.repository = repository;
    }

    // ✅ REQUIRED BY SPRING (no-arg)
    public PriorityRuleServiceImpl() {
    }

    @Override
    public int calculatePriority(String category) {
        if (repository == null) return 0;

        return repository.findAll().stream()
                .filter(PriorityRule::isActive)
                .filter(r -> r.getCategory().equalsIgnoreCase(category))
                .mapToInt(PriorityRule::getWeight)
                .sum();
    }

    @Override
    public List<PriorityRule> getAllRules() {
        if (repository == null) return new ArrayList<>();
        return repository.findAll();
    }

    // 🔥 THIS WAS MISSING → CAUSED BUILD FAILURE
    @Override
    public List<PriorityRule> getActiveRules() {
        if (repository == null) return new ArrayList<>();

        List<PriorityRule> active = new ArrayList<>();
        for (PriorityRule r : repository.findAll()) {
            if (r.isActive()) {
                active.add(r);
            }
        }
        return active;
    }

    @Override
    public void applyRules(Complaint complaint) {
        if (complaint == null || repository == null) return;

        for (PriorityRule rule : getActiveRules()) {
            complaint.getPriorityRules().add(rule);
            rule.getComplaints().add(complaint);
        }
    }
}
