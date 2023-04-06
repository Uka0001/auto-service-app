package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.CarRequestMapper;
import com.example.autoservice.dto.mapper.response.CarResponseMapper;
import com.example.autoservice.dto.request.CarRequestDto;
import com.example.autoservice.dto.response.CarResponseDto;
import com.example.autoservice.model.Car;
import com.example.autoservice.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/cars")
public class CarController {

    private final CarService carService;
    private final CarResponseMapper carResponseMapper;
    private final CarRequestMapper carRequestMapper;

    public CarController(CarService carService,
                         CarResponseMapper carResponseMapper,
                         CarRequestMapper carRequestMapper) {
        this.carService = carService;
        this.carResponseMapper = carResponseMapper;
        this.carRequestMapper = carRequestMapper;
    }

    @PostMapping("/add_car")
    public CarResponseDto addCar(@RequestBody CarRequestDto dto) {
        Car car = carService.save(carRequestMapper.fromDto(dto));
        return carResponseMapper.toDto(car);
    }

    @PutMapping("/update_car")
    public CarResponseDto updateCar(CarRequestDto requestDto, Long id) {
        Car car = carRequestMapper.fromDto(requestDto);
        car.setId(id);
        return carResponseMapper.toDto(carService.save(car));
    }
}
