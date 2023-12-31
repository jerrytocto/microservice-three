package com.jerrydev.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private int id ;
    private String brand ;
    private String model ;
    private int userId;
}
