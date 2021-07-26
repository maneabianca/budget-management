package com.example.budget.controller;

import com.example.budget.dto.UserDto;
import com.example.budget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController  {


    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createCurrency(@RequestBody UserDto userDto){

        userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
