package com.example.autoservice.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarResponseDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String number;
    private Long ownerId;
}
