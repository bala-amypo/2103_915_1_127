package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;

import java.util.List;

public interface PriorityRuleService {

    void applyRules(Complaint complaint);

    List<PriorityRule> getAllRules();

    List<PriorityRule> getActiveRules();
}
