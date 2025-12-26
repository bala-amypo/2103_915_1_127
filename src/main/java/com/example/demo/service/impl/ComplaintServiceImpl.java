package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
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

    // ✅ Constructor EXACTLY matches tests
    public ComplaintServiceImpl(ComplaintRepository complaintRepository,
                                PriorityRuleService priorityRuleService) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    // ✅ This method is REQUIRED by interface + tests
    @Override
    public Complaint submitComplaint(Complaint complaint) {

        // default values set pannrom
        complaint.setCreatedAt(LocalDateTime.now());
        complaint.setStatus(Complaint.Status.NEW);

        // ✅ VERY IMPORTANT LINE (you asked to verify this)
        complaint.setPriorityScore(
                priorityRuleService.computePriorityScore(complaint)
        );

        // rules apply (relation maintain panna)
        priorityRuleService.applyRules(complaint);

        return complaintRepository.save(complaint);
    }

    // ✅ Used in tests
    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    // ✅ Used in tests
    @Override
    public List<Complaint> getComplaintsForUser(com.example.demo.entity.User user) {
        return complaintRepository.findByCustomer(user);
    }

    // ✅ Used in tests (sorting logic)
    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository
                .findAllOrderByPriorityScoreDescCreatedAtAsc();
    }
}
