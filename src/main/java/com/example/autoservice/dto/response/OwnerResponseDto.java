package com.example.autoservice.dto.response;

import com.example.autoservice.model.Car;
import com.example.autoservice.model.Order;
import java.util.List;
import lombok.Setter;

@Setter
public class OwnerResponseDto {
    private Long id;
    private String ownerName;
    private List<Car> cars;
    private List<Order> orders;
}
