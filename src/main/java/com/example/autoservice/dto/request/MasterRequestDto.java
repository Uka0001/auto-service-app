package com.example.autoservice.dto.request;

import com.example.autoservice.model.Order;
import java.util.List;
import lombok.Getter;

@Getter
public class MasterRequestDto {
    private String fullName;
    private List<Order> completedOrder;
}
