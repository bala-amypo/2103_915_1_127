package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;

import java.util.List;

public class ComplaintStatusServiceImpl implements ComplaintStatusService {

    private final ComplaintStatusRepository complaintStatusRepository;

    public ComplaintStatusServiceImpl(ComplaintStatusRepository complaintStatusRepository) {
        this.complaintStatusRepository = complaintStatusRepository;
    }

    @Override
    public List<Complaint> getComplaintsByStatus(Complaint.Status status) {
        return complaintStatusRepository.findByStatus(status);
    }
}
