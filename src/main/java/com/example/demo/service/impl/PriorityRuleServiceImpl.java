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
    public void calculatePriorityScore(Complaint complaint) {

        int score = 0;

        switch (complaint.getSeverity()) {
            case HIGH -> score += 50;
            case MEDIUM -> score += 30;
            case LOW -> score += 10;
        }

        switch (complaint.getUrgency()) {
            case HIGH -> score += 40;
            case MEDIUM -> score += 20;
            case LOW -> score += 5;
        }

        complaint.setPriorityScore(score);
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findAll();
    }
}
