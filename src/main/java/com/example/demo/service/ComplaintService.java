package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;

import java.util.List;

public interface ComplaintService {

    Complaint submitComplaint(Complaint complaint);

    List<Complaint> getAllComplaints();

    List<Complaint> getComplaintsForUser(User user);

    // 🔴 THIS WAS MISSING
    List<Complaint> getPrioritizedComplaints();
}
