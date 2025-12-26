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

        if (complaint.getSeverity() == Complaint.Severity.HIGH) score += 50;
        else if (complaint.getSeverity() == Complaint.Severity.MEDIUM) score += 30;
        else score += 10;

        if (complaint.getUrgency() == Complaint.Urgency.HIGH) score += 40;
        else if (complaint.getUrgency() == Complaint.Urgency.MEDIUM) score += 20;
        else score += 5;

        complaint.setPriorityScore(score);
    }

    @Override
    public List<PriorityRule> getRules() {
        return priorityRuleRepository.getRules();
    }
}
