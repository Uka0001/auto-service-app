package com.example.autoservice.dto.request;

import com.example.autoservice.model.Owner;
import lombok.Getter;

@Getter
public class CarRequestDto {
    private String brand;
    private String model;
    private int year;
    private String number;
    private Long ownerId;
}
