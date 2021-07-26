package com.example.budget.controller;

import com.example.budget.dto.TransactionDto;
import com.example.budget.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/transaction")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;

    @GetMapping("/list")
    public ResponseEntity<?> getTransactionList(){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getTransactionList());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDto transactionDto) {

        System.out.println(transactionDto.toString());
        transactionService.createTransaction(transactionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateTransaction(@PathVariable Long id, @RequestBody TransactionDto transactionDto) {

        try {
            transactionService.updateTransaction(id, transactionDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        try {
            transactionService.deleteTransaction(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
