package com.example.autoservice.dto.response;

import java.math.BigDecimal;
import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.ServiceStatus;
import lombok.Setter;

@Setter
public class ServiceResponseDto {
    private Long id;
    private Order order;
    private Master master;
    private BigDecimal price;
    private ServiceStatus status;
}
