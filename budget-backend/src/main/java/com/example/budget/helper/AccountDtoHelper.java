package com.example.budget.helper;

import com.example.budget.dto.AccountDto;
import com.example.budget.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoHelper {

    @Autowired
    private UserDtoHelper userDtoHelper;

    @Autowired
    private CurrencyDtoHelper currencyDtoHelper;

    public AccountDto convertToDto(Account account){

        AccountDto accountDto = new AccountDto();

        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setCurrentBalance(account.getCurrentBalance());
        accountDto.setCurrencyDto(currencyDtoHelper.convertToDto(account.getCurrency()));
        accountDto.setUserDto(userDtoHelper.convertToDto(account.getUser()));


        return accountDto;
    }

    public Account convertToEntity(AccountDto accountDto){

        Account account = new Account();

        account.setId(accountDto.getId());
        account.setName(accountDto.getName());
        account.setCurrentBalance(accountDto.getCurrentBalance());
        account.setCurrency(currencyDtoHelper.convertToEntity(accountDto.getCurrencyDto()));
        account.setUser(userDtoHelper.convertToEntity(accountDto.getUserDto()));

        return account;
    }


}
