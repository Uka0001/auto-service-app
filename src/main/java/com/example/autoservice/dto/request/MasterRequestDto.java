package com.example.autoservice.dto.request;

import java.util.List;
import com.example.autoservice.model.Order;
import lombok.Getter;

@Getter
public class MasterRequestDto {
    private String fullName;
    private List<Order> completedOrder;
}
