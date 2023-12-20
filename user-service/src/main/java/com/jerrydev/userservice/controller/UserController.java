package com.jerrydev.userservice.controller;

import com.jerrydev.userservice.dto.UserDTO;
import com.jerrydev.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping
    private ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{userId}")
    private ResponseEntity<UserDTO> userById(@PathVariable int userId){
        return new ResponseEntity<>(userService.userById(userId),HttpStatus.OK);
    }

    @PostMapping()
    private ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return  new ResponseEntity<>(userService.saveUser(userDTO),HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    private ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable int userId){
        return new ResponseEntity<>(userService.updateUser(userDTO,userId), HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    private ResponseEntity<?> deleteMapping(@PathVariable int userId){
        userService.deleteUser(userId);
        return  new ResponseEntity<>("Objeto eliminado con éxito",HttpStatus.OK);
    }
}
