package com.example.demo.service;

import com.example.demo.entity.Complaint;

import java.util.List;

public interface ComplaintStatusService {

    List<Complaint> getByStatus(Complaint.Status status);
}
