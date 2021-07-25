package com.example.budget.dto;

import java.io.Serializable;

public class CurrencyDto implements Serializable {

    private Long id;
    private String name;
    private String code;
    private double value;

    public CurrencyDto(Long id, String name, String code, double value) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public CurrencyDto(){}

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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
