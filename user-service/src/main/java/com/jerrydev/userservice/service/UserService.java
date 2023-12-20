package com.jerrydev.userservice.service;

import com.jerrydev.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO userById(int userId);

    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO, int userId);

    void deleteUser(int userId);

}
