package com.example.demo.repository;

import com.example.demo.entity.Complaint;
import java.util.List;

public interface ComplaintStatusRepository {

    List<Complaint> findByStatus(Complaint.Status status);
}
