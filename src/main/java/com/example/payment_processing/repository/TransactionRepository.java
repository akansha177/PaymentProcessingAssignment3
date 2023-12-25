package com.example.payment_processing.repository;



import com.example.payment_processing.entity.Transaction;
import com.example.payment_processing.entity.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<List<Transaction>> findByStatus(TransactionStatus transactionStatus);
}