package com.jerrydev.bikeservice.controller;

import com.jerrydev.bikeservice.dto.BikeDTO;
import com.jerrydev.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    @Autowired
    public BikeService bikeService ;

    @GetMapping
    public ResponseEntity<List<BikeDTO>> getAllBikes(){
        return new ResponseEntity<>(bikeService.getAllBikes(), HttpStatus.OK);
    }

    @GetMapping("{bikeId}")
    public ResponseEntity<BikeDTO> bikeById(@PathVariable int bikeId){
        return new ResponseEntity<>(bikeService.bikeById(bikeId),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BikeDTO> saveBike(@RequestBody BikeDTO bikeDTO){
        return  new ResponseEntity<>(bikeService.saveBike(bikeDTO),HttpStatus.CREATED);
    }

    @PutMapping("{bikeId}")
    public ResponseEntity<BikeDTO> updateBike(@RequestBody BikeDTO bikeDTO, @PathVariable int bikeId){
        return new ResponseEntity<>(bikeService.updateBike(bikeDTO,bikeId), HttpStatus.OK);
    }

    @DeleteMapping("{bikeId}")
    public ResponseEntity<?> deleteMapping(@PathVariable int bikeId){
        bikeService.deleteBike(bikeId);
        return  new ResponseEntity<>("Objeto eliminado con éxito",HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BikeDTO>> bikesByUserId(@PathVariable int userId){
        return new ResponseEntity<>(bikeService.bikesByUserId(userId), HttpStatus.OK);
    }
}
