package com.jerrydev.bikeservice.service.impl;

import com.jerrydev.bikeservice.dto.BikeDTO;
import com.jerrydev.bikeservice.dto.BikeMapper;
import com.jerrydev.bikeservice.entity.Bike;
import com.jerrydev.bikeservice.repository.BikeRepository;
import com.jerrydev.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BikeServiceImpl implements BikeService{

    @Autowired
    private BikeRepository bikeRepository ;

    @Autowired
    private BikeMapper bikeMapper ;

    @Override
    public List<BikeDTO> getAllBikes() {

        List<Bike> bikeList = bikeRepository.findAll();
        List<BikeDTO> bikeDTOList = new ArrayList<>();

        if(!bikeList.isEmpty()) {
            for (Bike bike : bikeList) {
                bikeDTOList.add(bikeMapper.fromBike(bike));
            }
            return bikeDTOList;
        }
        return bikeDTOList;
    }

    @Override
    public BikeDTO bikeById(int bikeId) {
        return bikeMapper.fromBike(bikeRepository.findById(bikeId).get());
    }

    @Override
    public BikeDTO saveBike(BikeDTO bikeDTO) {
        return bikeMapper.fromBike(bikeRepository.save(bikeMapper.fromBikeDTO(bikeDTO)));
    }

    @Override
    public BikeDTO updateBike(BikeDTO bikeDTO, int bikeId) {

        Bike bike = bikeRepository.findById(bikeId).get();

        if(bike==null) return new BikeDTO();

        bike.setBrand(bikeDTO.getBrand());
        bike.setModel(bikeDTO.getModel());
        bike.setUserId(bikeDTO.getUserId());

        return bikeMapper.fromBike(bikeRepository.save(bike));
    }

    @Override
    public void deleteBike(int bikeId) {
        bikeRepository.deleteById(bikeId);
    }

    @Override
    public List<BikeDTO> bikesByUserId(int userId) {
        List<Bike> bikeList = bikeRepository.findByUserId(userId);
        List<BikeDTO> bikeDTOList = new ArrayList<>();

        if(!bikeList.isEmpty()) {
            for (Bike bike : bikeList) {
                bikeDTOList.add(bikeMapper.fromBike(bike));
            }
            return bikeDTOList;
        }
        return bikeDTOList;
    }
}
