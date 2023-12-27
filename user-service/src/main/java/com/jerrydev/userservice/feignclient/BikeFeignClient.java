package com.jerrydev.userservice.feignclient;

import com.jerrydev.userservice.dto.BikeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "bike-service")
public interface BikeFeignClient {

    @GetMapping("/api/v1/bikes/user/{userId}")
    List<BikeDTO> bikesByUserId(@PathVariable int userId);

    @PostMapping("/api/v1/bikes")
    BikeDTO saveBike(@RequestBody BikeDTO bikeDTO);
}
