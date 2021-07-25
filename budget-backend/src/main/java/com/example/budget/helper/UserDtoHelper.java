package com.example.budget.helper;

import com.example.budget.dto.UserDto;
import com.example.budget.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoHelper {


    public UserDto convertToDto(User user){

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    public User convertToEntity(UserDto userDto){
        User user = new User();

        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }
}
