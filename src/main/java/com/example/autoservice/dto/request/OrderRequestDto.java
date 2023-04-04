package com.example.autoservice.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.example.autoservice.model.Car;
import com.example.autoservice.model.Good;
import com.example.autoservice.model.Master;
import com.example.autoservice.model.OrderStatus;
import com.example.autoservice.model.Service;
import lombok.Getter;

@Getter
public class OrderRequestDto {
    private Car car;
    private Master master;
    private String description;
    private LocalDate dateOfAdoption;
    private List<Service> serviceList;
    private List<Good> goodsList;
    private OrderStatus status;
    private BigDecimal totalCost;
    private LocalDate completionDate;
}