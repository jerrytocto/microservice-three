package com.jerrydev.userservice.dto;

import com.jerrydev.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO fromUser(User user){
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public  User fromUserDTO(UserDTO userDTO){
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        return  user ;
    }
}
