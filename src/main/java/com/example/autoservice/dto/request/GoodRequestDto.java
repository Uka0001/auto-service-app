package com.example.autoservice.dto.request;

import com.example.autoservice.model.Order;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class GoodRequestDto {
    private String name;
    private BigDecimal goodCost;
    private Order order;
}
