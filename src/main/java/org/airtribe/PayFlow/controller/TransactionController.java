package org.airtribe.PayFlow.controller;



import org.airtribe.PayFlow.entity.Transaction;
import org.airtribe.PayFlow.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // POST /transactions - Send money (create a transaction)
    @PostMapping
    public ResponseEntity<Transaction> sendMoney(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.sendMoney(transaction);
        return ResponseEntity.ok(savedTransaction);
    }
}