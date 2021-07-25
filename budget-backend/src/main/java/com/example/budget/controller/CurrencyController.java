package com.example.budget.controller;

import com.example.budget.dto.CurrencyDto;
import com.example.budget.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/list")
    public ResponseEntity<?> getCurrencyList(){
        return ResponseEntity.status(HttpStatus.OK).body(currencyService.getCurrencyList());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCurrency(@RequestBody CurrencyDto currencyDto){

        currencyService.createCurrency(currencyDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateCurrency(@PathVariable Long id, @RequestBody CurrencyDto currencyDto){

        try {
            currencyService.updateCurrency(id, currencyDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteCurrency(@PathVariable Long id){

        try {
            currencyService.deleteCurrency(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
