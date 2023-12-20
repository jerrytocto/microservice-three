package com.jerrydev.bikeservice.service;

import com.jerrydev.bikeservice.dto.BikeDTO;

import java.util.List;

public interface BikeService {

    List<BikeDTO> getAllBikes();

    BikeDTO bikeById(int bikeId);

    BikeDTO saveBike(BikeDTO bikeDTO);

    BikeDTO updateBike(BikeDTO bikeDTO, int bikeId);

    void deleteBike(int bikeId);

    List<BikeDTO> bikesByUserId(int userId);
}
