package com.example.budget.service;


import com.example.budget.dto.AccountDto;
import com.example.budget.helper.AccountDtoHelper;
import com.example.budget.helper.CurrencyDtoHelper;
import com.example.budget.model.Account;
import com.example.budget.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountDtoHelper accountDtoHelper;

    @Autowired
    private CurrencyDtoHelper currencyDtoHelper;


    public List<AccountDto> getAccountList() {
        List<Account> accountList = accountRepository.findAll();
        List<AccountDto> accountDtoList = new ArrayList<>();

        for(Account account: accountList){
            accountDtoList.add(accountDtoHelper.convertToDto(account));
        }
        return accountDtoList;
    }

    public void createAccount(AccountDto accountDto) {
        Account account = accountDtoHelper.convertToEntity(accountDto);
        accountRepository.saveAndFlush(account);
    }


    public void updateAccount(Long id, AccountDto accountDto) throws Exception {
        Optional<Account> account = accountRepository.findById(id);
        if(!account.isPresent()){
            throw new Exception("The account with "+id+" does'nt exist.");
        }
        account.get().setName(accountDto.getName());
        account.get().setCurrentBalance(accountDto.getCurrentBalance());
        account.get().setCurrency(currencyDtoHelper.convertToEntity(accountDto.getCurrencyDto()));

        accountRepository.saveAndFlush(account.get());
    }

    public void deleteAccount(Long id) throws Exception {
        if(!accountRepository.existsById(id)){
            throw new Exception("The account with "+ id +" doesn't exist.");
        }
        accountRepository.deleteById(id);
    }


}
