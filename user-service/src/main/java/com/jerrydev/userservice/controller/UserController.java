package com.jerrydev.userservice.controller;

import com.jerrydev.userservice.dto.BikeDTO;
import com.jerrydev.userservice.dto.CarDTO;
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

    @GetMapping("{userId}/bikes")
    private ResponseEntity<List<BikeDTO>> bikesByUserId(@PathVariable int userId){
        return  new ResponseEntity<>(userService.bikesByUserId(userId),HttpStatus.OK);
    }

    @PostMapping("{userId}/save-car")
    private ResponseEntity<?> saveBikeByUserId(@RequestBody BikeDTO bikeDTO, @PathVariable int userId){

        return  new ResponseEntity<>(
                userService.saveBikeByUserId(userId,bikeDTO)!=null?
                        userService.saveBikeByUserId(userId,bikeDTO):
                        "No se pudo crear un bike para el usuario con id: "+ userId,
                HttpStatus.CREATED);
    }

    @GetMapping("{userId}/cars")
    private ResponseEntity<List<CarDTO>> carsByUserId(@PathVariable int userId){
        return  new ResponseEntity<>(userService.carsByUserId(userId),HttpStatus.OK);
    }

    @PostMapping("{userId}/save-car")
    private ResponseEntity<?> saveCarByUserId(@RequestBody CarDTO carDTO, @PathVariable int userId){

        return  new ResponseEntity<>(
                userService.saveCar(userId,carDTO)!=null ?
                        userService.saveCar(userId,carDTO):
                        "No se pudo crear un car para el usuario con id: "+ userId,
                HttpStatus.CREATED);
    }
}
