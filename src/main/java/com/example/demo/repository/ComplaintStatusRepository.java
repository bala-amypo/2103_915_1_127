package com.example.demo.repository;

import com.example.demo.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintStatusRepository
        extends JpaRepository<Complaint, Long> {

    List<Complaint> findByStatus(Complaint.Status status);
}
