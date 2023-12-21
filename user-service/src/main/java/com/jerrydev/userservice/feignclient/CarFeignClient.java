package com.jerrydev.userservice.feignclient;

import com.jerrydev.userservice.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "car-service" , url = "http://localhost:8002/api/v1/cars")
public interface CarFeignClient {
    @GetMapping("/user/{userId}")
    List<CarDTO> carsByUserId(@PathVariable int userId);

    @PostMapping()
    CarDTO saveCar(@RequestBody CarDTO carDTO);

}
