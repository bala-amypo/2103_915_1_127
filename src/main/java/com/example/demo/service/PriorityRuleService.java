package com.example.demo.service;

import com.example.demo.entity.Complaint;

public interface PriorityRuleService {

    void computePriorityScore(Complaint complaint);
}
