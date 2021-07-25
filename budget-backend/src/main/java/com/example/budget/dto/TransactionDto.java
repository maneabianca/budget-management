package com.example.budget.dto;


import java.io.Serializable;

public class TransactionDto implements Serializable {
    private Long id;
    private String transactionDate;
    private String description;
    private double value;
    private CategoryDto categoryDto;
    private AccountDto accountDto;

    public TransactionDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", transactionDate='" + transactionDate + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", categoryDto=" + categoryDto +
                ", accountDto=" + accountDto +
                '}';
    }
}
