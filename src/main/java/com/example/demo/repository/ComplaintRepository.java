package com.example.demo.repository;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    // ✅ REQUIRED BY SERVICE + TESTS
    List<Complaint> findByCustomer(User customer);

    // ✅ REQUIRED BY PRIORITIZATION
    List<Complaint> findAllOrderByPriorityScoreDescCreatedAtAsc();
}
