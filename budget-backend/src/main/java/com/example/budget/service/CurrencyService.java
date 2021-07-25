package com.example.budget.service;

import com.example.budget.dto.CurrencyDto;
import com.example.budget.helper.CurrencyDtoHelper;
import com.example.budget.model.Currency;
import com.example.budget.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyDtoHelper currencyDtoHelper;


    public List<CurrencyDto> getCurrencyList() {

        List<Currency> currencyList = currencyRepository.findAll();
        List<CurrencyDto> currencyDtoList = new ArrayList<>();

        for(Currency currency: currencyList){
            currencyDtoList.add(currencyDtoHelper.convertToDto(currency));
        }
        return currencyDtoList;

    }

    public void createCurrency(CurrencyDto currencyDto){

        Currency newCurrency = currencyDtoHelper.convertToEntity(currencyDto);
        currencyRepository.saveAndFlush(newCurrency);
    }


    public void updateCurrency(Long id, CurrencyDto currencyDto) throws Exception {
        Optional<Currency> currency = currencyRepository.findById(id);
        if(!currency.isPresent()){
            throw new Exception("The currency with "+id+" does'nt exist.");
        }
        currency.get().setName(currencyDto.getName());
        currency.get().setValue(currencyDto.getValue());
        currency.get().setCode(currencyDto.getCode());

        currencyRepository.saveAndFlush(currency.get());


    }

    public void deleteCurrency(Long id) throws Exception{
        if(!currencyRepository.existsById(id)){
            throw new Exception("The currency with "+ id +" doesn't exist.");
        }
        currencyRepository.deleteById(id);


    }
}
