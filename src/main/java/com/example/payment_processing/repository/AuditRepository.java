package com.example.payment_processing.repository;



import com.example.payment_processing.entity.AuditEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditEntry, Long> {
}
