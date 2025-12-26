package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;

    // ✅ Constructor exactly as tests expect
    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            PriorityRuleService priorityRuleService) {

        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    // ✅ Tests expect this signature
    @Override
    public Complaint submitComplaint(ComplaintRequest request, User user) {

        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setCategory(request.getCategory());
        complaint.setChannel(request.getChannel());

        complaint.setSeverity(
                Complaint.Severity.valueOf(request.getSeverity().toUpperCase())
        );

        complaint.setUrgency(
                Complaint.Urgency.valueOf(request.getUrgency().toUpperCase())
        );

        complaint.setCreatedAt(LocalDateTime.now());

        // ✅ Correct method name (matches interface + tests)
        priorityRuleService.calculatePriorityScore(complaint);

        return complaintRepository.save(complaint);
    }

    // ✅ Tests expect this method
    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository
                .findAllOrderByPriorityScoreDescCreatedAtAsc();
    }
}
