package com.example.budget.helper;

import com.example.budget.dto.CurrencyDto;
import com.example.budget.model.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDtoHelper {

    public CurrencyDto convertToDto(Currency currency){

        CurrencyDto currencyDto = new CurrencyDto();

        currencyDto.setId(currency.getId());
        currencyDto.setName(currency.getName());
        currencyDto.setValue(currency.getValue());
        currencyDto.setCode(currency.getCode());

        return currencyDto;
    }

    public Currency convertToEntity(CurrencyDto currencyDto){

        Currency currency = new Currency();

        currency.setId(currencyDto.getId());
        currency.setName(currencyDto.getName());
        currency.setCode(currencyDto.getCode());
        currency.setValue(currencyDto.getValue());

        return currency;
    }
}
