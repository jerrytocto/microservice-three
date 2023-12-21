package com.jerrydev.userservice.service.impl;

import com.jerrydev.userservice.dto.BikeDTO;
import com.jerrydev.userservice.dto.CarDTO;
import com.jerrydev.userservice.dto.UserDTO;
import com.jerrydev.userservice.dto.UserMapper;
import com.jerrydev.userservice.entity.User;
import com.jerrydev.userservice.feignclient.BikeFeignClient;
import com.jerrydev.userservice.feignclient.CarFeignClient;
import com.jerrydev.userservice.repository.UserRepository;
import com.jerrydev.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private UserMapper userMapper ;

    @Autowired
    private BikeFeignClient bikeFeignClient ;

    @Autowired
    private CarFeignClient carFeignClient;


    @Override
    public List<UserDTO> getAllUsers() {

        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        if(!userList.isEmpty()) {
            for (User user : userList) {
                userDTOList.add(userMapper.fromUser(user));
            }
            return userDTOList;
        }
        return userDTOList;
    }

    @Override
    public UserDTO userById(int userId) {
        return userMapper.fromUser(userRepository.findById(userId).get());
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return userMapper.fromUser(userRepository.save(userMapper.fromUserDTO(userDTO)));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, int userId) {

        User user = userRepository.findById(userId).get();

        if(user==null) return new UserDTO();

        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        return userMapper.fromUser(userRepository.save(user));
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<BikeDTO> bikesByUserId(int userId) {
        return bikeFeignClient.bikesByUserId(userId);
    }

    @Override
    public List<CarDTO> carsByUserId(int userId) {
        return carFeignClient.carsByUserId(userId);
    }

    @Override
    public CarDTO saveCar(int userId, CarDTO carDTO) {
        User foundUser = userRepository.findById(userId).get();

        if(foundUser!=null){
            carDTO.setUserId(userId);
            return carFeignClient.saveCar(carDTO);
        }
        return new CarDTO();
    }
    @Override
    public BikeDTO saveBikeByUserId(int userId, BikeDTO bikeDTO) {
        User foundUser = userRepository.findById(userId).get();

        if(foundUser!=null){
            bikeDTO.setUserId(userId);
            return bikeFeignClient.saveBike(bikeDTO);
        }
        return new BikeDTO();
    }
}
