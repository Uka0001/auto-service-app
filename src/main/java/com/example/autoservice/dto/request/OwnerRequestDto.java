package com.example.autoservice.dto.request;

import com.example.autoservice.model.Car;
import com.example.autoservice.model.Order;
import java.util.List;
import lombok.Getter;

@Getter
public class OwnerRequestDto {
    private String ownerName;
    private List<Car> cars;
    private List<Order> orders;
}
