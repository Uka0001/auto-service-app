package com.example.autoservice.dto.response;

import com.example.autoservice.model.Owner;
import lombok.Setter;

@Setter
public class CarResponseDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String number;
    private Owner owner;
}
