package com.example.budget.service;

import com.example.budget.dto.UserDto;
import com.example.budget.helper.UserDtoHelper;
import com.example.budget.model.User;
import com.example.budget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDtoHelper userDtoHelper;


    public void createUser(UserDto userDto) {
        User newUser = userDtoHelper.convertToEntity(userDto);
        userRepository.saveAndFlush(newUser);
    }
}
