package com.jerrydev.carservice.service.impl;

import com.jerrydev.carservice.dto.CarDTO;
import com.jerrydev.carservice.dto.CarMapper;
import com.jerrydev.carservice.entity.Car;
import com.jerrydev.carservice.repository.CarRepository;
import com.jerrydev.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository ;

    @Autowired
    private CarMapper carMapper ;

    @Override
    public List<CarDTO> getAllCars() {

        List<Car> carList = carRepository.findAll();
        List<CarDTO> carDTOList = new ArrayList<>();

        if(!carList.isEmpty()) {
            for (Car car : carList) {
                carDTOList.add(carMapper.fromCar(car));
            }
            return carDTOList;
        }
        return carDTOList;
    }

    @Override
    public CarDTO carById(int carId) {
        return carMapper.fromCar(carRepository.findById(carId).get());
    }

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        return carMapper.fromCar(carRepository.save(carMapper.fromCarDTO(carDTO)));
    }

    @Override
    public CarDTO updateCar(CarDTO carDTO, int carId) {

        Car car = carRepository.findById(carId).get();

        if(car==null) return new CarDTO();

        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setUserId(carDTO.getUserId());

        return carMapper.fromCar(carRepository.save(car));
    }

    @Override
    public void deleteCar(int carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public List<CarDTO> carsByUserId(int userId) {
        List<Car> carList = carRepository.findByUserId(userId);
        List<CarDTO> carDTOList = new ArrayList<>();

        if(!carList.isEmpty()) {
            for (Car car : carList) {
                carDTOList.add(carMapper.fromCar(car));
            }
            return carDTOList;
        }
        return carDTOList;
    }
}
