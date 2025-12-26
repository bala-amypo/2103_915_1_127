package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository priorityRuleRepository;

    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public void applyRules(Complaint complaint) {

        List<PriorityRule> rules = priorityRuleRepository.findAll();

        for (PriorityRule rule : rules) {
            if (rule.isActive()) {
                // 🔥 FIX: no + operator, just apply
                rule.apply(complaint);
            }
        }
    }

    @Override
    public List<PriorityRule> getAllRules() {
        return priorityRuleRepository.findAll();
    }
}
