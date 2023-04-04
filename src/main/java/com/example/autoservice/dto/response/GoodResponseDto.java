package com.example.autoservice.dto.response;

import java.math.BigDecimal;
import com.example.autoservice.model.Order;
import lombok.Setter;

@Setter
public class GoodResponseDto {
    private Long id;
    private String name;
    private BigDecimal goodCost;
    private Order order;
}
