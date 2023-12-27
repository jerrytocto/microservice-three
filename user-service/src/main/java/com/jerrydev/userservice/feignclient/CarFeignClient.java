package com.jerrydev.userservice.feignclient;

import com.jerrydev.userservice.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "car-service")
public interface CarFeignClient {
    @GetMapping("/api/v1/cars/user/{userId}")
    List<CarDTO> carsByUserId(@PathVariable int userId);

    @PostMapping("/api/v1/cars")
    CarDTO saveCar(@RequestBody CarDTO carDTO);
}
