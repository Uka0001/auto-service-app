package com.example.autoservice.dto.response;

import com.example.autoservice.model.Order;
import java.math.BigDecimal;
import lombok.Setter;

@Setter
public class GoodResponseDto {
    private Long id;
    private String name;
    private BigDecimal goodCost;
    private Order order;
}
