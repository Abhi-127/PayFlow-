package org.airtribe.PayFlow.service;




import org.airtribe.PayFlow.entity.Transaction;
import org.airtribe.PayFlow.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    // Spring automatically injects TransactionRepository at startup through dependency injection.
    // This works because Spring creates a bean for TransactionRepository (since it's a JpaRepository)
    // and injects it wherever @Autowired is used.
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction sendMoney(Transaction transaction) {
        // For now, just save the transaction record.
        // Balance deduction logic will be added in a future session.
        return transactionRepository.save(transaction);
    }
}