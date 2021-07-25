package com.example.budget.service;

import com.example.budget.dto.TransactionDto;
import com.example.budget.helper.CategoryDtoHelper;
import com.example.budget.helper.TransactionDtoHelper;
import com.example.budget.model.Transaction;
import com.example.budget.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionDtoHelper transactionDtoHelper;

    @Autowired
    private CategoryDtoHelper categoryDtoHelper;

    public List<TransactionDto> getTransactionList() {
        List<Transaction> transactionList = transactionRepository.findAll();
        List<TransactionDto> transactionDtoList = new ArrayList<>();

        for(Transaction transaction: transactionList){
            transactionDtoList.add(transactionDtoHelper.convertToDto(transaction));
        }
        return transactionDtoList;

    }

    public void createTransaction(TransactionDto transactionDto) {
        Transaction transaction = transactionDtoHelper.convertToEntity(transactionDto);
        transactionRepository.saveAndFlush(transaction);
    }

    public void updateTransaction(Long id, TransactionDto transactionDto) throws Exception {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(!transaction.isPresent()){
            throw new Exception("The transaction with "+id+" does'nt exist.");
        }
        transaction.get().setTransactionDate(LocalDate.parse(transactionDto.getTransactionDate()));
        transaction.get().setDescription(transactionDto.getDescription());
        transaction.get().setValue(transactionDto.getValue());
        transaction.get().setCategory(categoryDtoHelper.convertToEntity(transactionDto.getCategoryDto()));

        transactionRepository.saveAndFlush(transaction.get());

    }

    public void deleteTransaction(Long id) throws Exception {
        if(!transactionRepository.existsById(id)){
            throw new Exception("The transaction with "+ id +" doesn't exist.");
        }
        transactionRepository.deleteById(id);
    }
}
