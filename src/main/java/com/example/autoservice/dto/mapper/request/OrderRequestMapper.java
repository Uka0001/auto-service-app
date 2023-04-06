package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.OrderRequestDto;
import com.example.autoservice.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper
        implements DtoRequestMapper<OrderRequestDto, Order> {
    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setStatus(dto.getStatus());
        order.setCar(dto.getCar());
        order.setMaster(dto.getMaster());
        order.setDescription(dto.getDescription());
        order.setGoodsList(dto.getGoodsList());
        order.setCompletionDate(dto.getCompletionDate());
        order.setServiceList(dto.getServiceList());
        order.setDateOfAdoption(dto.getDateOfAdoption());
        order.setTotalCost(dto.getTotalCost());
        return order;
    }
}
