package org.airtribe.PayFlow.repository;


import org.airtribe.PayFlow.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
}