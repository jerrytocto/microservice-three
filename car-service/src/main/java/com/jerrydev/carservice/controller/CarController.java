package com.jerrydev.carservice.controller;

import com.jerrydev.carservice.dto.CarDTO;
import com.jerrydev.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    public CarService carService ;

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars(){
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("{carId}")
    public ResponseEntity<CarDTO> carById(@PathVariable int carId){
        return new ResponseEntity<>(carService.carById(carId),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDTO){
        return  new ResponseEntity<>(carService.saveCar(carDTO),HttpStatus.CREATED);
    }

    @PutMapping("{carId}")
    public ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO carDTO, @PathVariable int carId){
        return new ResponseEntity<>(carService.updateCar(carDTO,carId), HttpStatus.OK);
    }

    @DeleteMapping("{carId}")
    public ResponseEntity<?> deleteMapping(@PathVariable int carId){
        carService.deleteCar(carId);
        return  new ResponseEntity<>("Objeto eliminado con éxito",HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CarDTO>> carsByUserId(@PathVariable int userId){
        return new ResponseEntity<>(carService.carsByUserId(userId), HttpStatus.OK);
    }
}
