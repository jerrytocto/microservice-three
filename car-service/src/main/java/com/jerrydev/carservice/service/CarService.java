package com.jerrydev.carservice.service;

import com.jerrydev.carservice.dto.CarDTO;

import java.util.List;

public interface CarService {

    List<CarDTO> getAllCars();

    CarDTO carById(int carId);

    CarDTO saveCar(CarDTO carDTO);

    CarDTO updateCar(CarDTO carDTO, int carId);

    void deleteCar(int carId);

    List<CarDTO> carsByUserId(int userId);
}
