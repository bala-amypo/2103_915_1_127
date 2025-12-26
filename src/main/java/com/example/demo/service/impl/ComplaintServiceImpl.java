package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;

import java.time.LocalDateTime;
import java.util.List;

public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;

    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            PriorityRuleService priorityRuleService
    ) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest request, User user) {
        Complaint c = new Complaint();

        c.setTitle(request.getTitle());
        c.setDescription(request.getDescription());

        // ✅ STRING → ENUM (TEST EXPECTED)
        c.setSeverity(Complaint.Severity.valueOf(request.getSeverity()));
        c.setUrgency(Complaint.Urgency.valueOf(request.getUrgency()));

        c.setCustomer(user);
        c.setStatus(Complaint.Status.NEW);
        c.setCreatedAt(LocalDateTime.now());

        int score = priorityRuleService.computePriorityScore(c);
        c.setPriorityScore(score);

        return complaintRepository.save(c);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User user) {
        return complaintRepository.findByCustomer(user);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository
                .findAllOrderByPriorityScoreDescCreatedAtAsc();
    }
}
