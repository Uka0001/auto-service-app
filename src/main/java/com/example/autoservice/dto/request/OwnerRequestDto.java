package com.example.autoservice.dto.request;

import java.util.List;
import com.example.autoservice.model.Car;
import com.example.autoservice.model.Order;
import lombok.Getter;

@Getter
public class OwnerRequestDto {
    private String ownerName;
    private List<Car> cars;
    List<Order> orders;
}
