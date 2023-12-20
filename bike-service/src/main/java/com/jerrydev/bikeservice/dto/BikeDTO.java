package com.jerrydev.bikeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BikeDTO {

    private int id ;
    private String brand ;
    private String model ;
    private int userId;
}
