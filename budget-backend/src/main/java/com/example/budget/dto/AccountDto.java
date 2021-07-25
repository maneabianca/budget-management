package com.example.budget.dto;

import java.io.Serializable;

public class AccountDto implements Serializable {

    private Long id;
    private String name;
    private double currentBalance;
    private CurrencyDto currencyDto;
    private UserDto userDto;

    public AccountDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public CurrencyDto getCurrencyDto() {
        return currencyDto;
    }

    public void setCurrencyDto(CurrencyDto currencyDto) {
        this.currencyDto = currencyDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
