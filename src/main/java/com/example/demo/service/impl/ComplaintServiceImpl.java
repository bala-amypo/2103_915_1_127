package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;

    // ✅ Constructor Injection
    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            PriorityRuleService priorityRuleService
    ) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint submitComplaint(Complaint complaint) {

        if (complaint.getPriorityRules() == null) {
            complaint.setPriorityRules(new HashSet<>());
        }

        int score = priorityRuleService.computePriorityScore(complaint);
        complaint.setPriorityScore(score);

        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User user) {
        return complaintRepository.findByCustomer(user);
    }

    @Override
    public void updateStatus(Long complaintId, String status) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setStatus(Complaint.Status.valueOf(status));
        complaintRepository.save(complaint);
    }

    // ✅ THIS METHOD FIXES YOUR CURRENT ERROR
    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllOrderByPriorityScoreDesc();
    }
}
