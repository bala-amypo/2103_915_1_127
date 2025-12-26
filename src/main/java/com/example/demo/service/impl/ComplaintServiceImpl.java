package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final UserService userService;
    private final PriorityRuleService priorityRuleService;

    // ✅ CONSTRUCTOR MUST MATCH TEST
    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            UserService userService,
            PriorityRuleService priorityRuleService) {

        this.complaintRepository = complaintRepository;
        this.userService = userService;
        this.priorityRuleService = priorityRuleService;
    }

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

        // priority calculation happens in rule service
        priorityRuleService.applyRules(complaint);

        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository
                .findAllOrderByPriorityScoreDescCreatedAtAsc();
    }
}
