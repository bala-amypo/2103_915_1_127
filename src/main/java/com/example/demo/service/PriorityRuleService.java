package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;

import java.util.List;

public interface PriorityRuleService {

    void applyRules(Complaint complaint);

    int computePriorityScore(Complaint complaint); // ✅ ADD THIS

    List<PriorityRule> getAllRules();

    List<PriorityRule> getActiveRules();
}
