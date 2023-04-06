package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper
        implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setCar(order.getCar());
        responseDto.setMaster(order.getMaster());
        responseDto.setDescription(order.getDescription());
        responseDto.setStatus(order.getStatus());
        responseDto.setGoodsList(order.getGoodsList());
        responseDto.setCompletionDate(order.getCompletionDate());
        responseDto.setDateOfAdoption(order.getDateOfAdoption());
        responseDto.setServiceList(order.getServiceList());
        responseDto.setTotalCost(order.getTotalCost());
        return responseDto;
    }
}
