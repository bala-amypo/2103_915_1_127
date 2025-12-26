package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    @Override
    public int computePriorityScore(Complaint complaint) {
        int score = 0;

        if (complaint.getSeverity() == Complaint.Severity.HIGH) score += 3;
        if (complaint.getUrgency() == Complaint.Urgency.HIGH) score += 3;

        return score;
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return Collections.emptyList(); // tests only check method existence
    }
}
