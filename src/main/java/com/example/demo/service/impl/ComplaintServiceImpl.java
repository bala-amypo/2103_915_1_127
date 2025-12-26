package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest request, User user) {
        Complaint complaint = new Complaint();
        complaint.setStatus(Complaint.Status.NEW);
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User user) {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAll();
    }

    // ✅ REQUIRED METHOD (FIX)
    @Override
    public void updateStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setStatus(Complaint.Status.valueOf(status));
        complaintRepository.save(complaint);
    }
}
