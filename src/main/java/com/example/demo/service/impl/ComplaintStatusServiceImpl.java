package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService {

    private final ComplaintStatusRepository repository;

    public ComplaintStatusServiceImpl(ComplaintStatusRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Complaint> getByStatus(Complaint.Status status) {
        return repository.findByStatus(status);
    }
}
