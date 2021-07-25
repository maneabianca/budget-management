package com.example.budget.helper;

import com.example.budget.dto.TransactionDto;
import com.example.budget.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TransactionDtoHelper {

    @Autowired
    private AccountDtoHelper accountDtoHelper;

    @Autowired
    private CategoryDtoHelper categoryDtoHelper;

    public TransactionDto convertToDto(Transaction transaction){

        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setId(transaction.getId());
        transactionDto.setTransactionDate(transaction.getTransactionDate().toString());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setValue(transaction.getValue());
        transactionDto.setCategoryDto(categoryDtoHelper.convertToDto(transaction.getCategory()));
        transactionDto.setAccountDto(accountDtoHelper.convertToDto(transaction.getAccount()));


        return transactionDto;
    }

    public Transaction convertToEntity(TransactionDto transactionDto){

        Transaction transaction = new Transaction();

        transaction.setId(transactionDto.getId());
        System.out.println(transactionDto.getTransactionDate());
        transaction.setTransactionDate(LocalDate.parse(transactionDto.getTransactionDate()));
        transaction.setDescription(transactionDto.getDescription());
        transaction.setValue(transactionDto.getValue());
        transaction.setCategory(categoryDtoHelper.convertToEntity(transactionDto.getCategoryDto()));
        transaction.setAccount(accountDtoHelper.convertToEntity(transactionDto.getAccountDto()));

        return transaction;
    }
}
