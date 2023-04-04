package com.example.autoservice.dto.response;

import java.util.List;
import com.example.autoservice.model.Car;
import com.example.autoservice.model.Order;
import lombok.Setter;

@Setter
public class OwnerResponseDto {
    private Long id;
    private String ownerName;
    private List<Car> cars;
    List<Order> orders;
}
