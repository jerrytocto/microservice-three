package com.jerrydev.bikeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_bike")
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String brand ;
    private String model ;
    private int userId;
}
