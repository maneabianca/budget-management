package com.example.budget.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_date", columnDefinition = "DATE")
    private LocalDate transactionDate;
    private String description;

    private double value;

    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="account_id",nullable = false)
    private Account account;

}
