package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.CarRequestDto;
import com.example.autoservice.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarRequestMapper implements DtoRequestMapper<CarRequestDto, Car> {
    @Override
    public Car fromDto(CarRequestDto dto) {
        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setOwner(dto.getOwner());
        car.setNumber(dto.getNumber());
        return car;
    }
}
