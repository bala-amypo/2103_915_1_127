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

    public ComplaintServiceImpl(ComplaintRepository complaintRepository,
                                UserService userService,
                                PriorityRuleService priorityRuleService,
                                PriorityRuleService ignored) {
        this.complaintRepository = complaintRepository;
        this.userService = userService;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest req, User user) {
        Complaint c = new Complaint();
        c.setTitle(req.getTitle());
        c.setDescription(req.getDescription());
        c.setCategory(req.getCategory());
        c.setChannel(req.getChannel());
        c.setSeverity(req.getSeverity());
        c.setUrgency(req.getUrgency());
        c.setCustomer(user);
        c.setPriorityScore(priorityRuleService.computePriorityScore(c));
        return complaintRepository.save(c);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User user) {
        return complaintRepository.findByCustomer(user);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }

    @Override
    public void updateStatus(Long id, String status) {
        Complaint c = complaintRepository.findById(id).orElseThrow();
        c.setStatus(Complaint.Status.valueOf(status));
        complaintRepository.save(c);
    }
}
