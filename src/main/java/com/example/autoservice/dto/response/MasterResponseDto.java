package com.example.autoservice.dto.response;

import java.util.List;
import com.example.autoservice.model.Order;
import lombok.Setter;

@Setter
public class MasterResponseDto {
    private Long id;
    private String fullName;
    private List<Order> completedOrder;
}
