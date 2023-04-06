package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.OrderRequestMapper;
import com.example.autoservice.dto.mapper.response.OrderResponseMapper;
import com.example.autoservice.dto.request.OrderRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Order;
import com.example.autoservice.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/orders")
public class OrdersControllers {
    private final OrderService orderService;
    private final OrderResponseMapper responseMapper;
    private final OrderRequestMapper requestMapper;

    public OrdersControllers(OrderService orderService,
                             OrderResponseMapper responseMapper,
                             OrderRequestMapper requestMapper) {
        this.orderService = orderService;
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
    }

    @PostMapping("/create_order")
    public OrderResponseDto addOrder(@RequestBody OrderRequestDto dto) {
        Order order = orderService.save(requestMapper.fromDto(dto));
        return responseMapper.toDto(order);
    }

    @PutMapping("/update_order")
    public OrderResponseDto updateOrder(OrderRequestDto requestDto, Long id) {
        Order order = requestMapper.fromDto(requestDto);
        order.setId(id);
        return responseMapper.toDto(orderService.save(order));
    }

    @PutMapping("/update_order_status")
    public OrderResponseDto updateOrderStatus(OrderRequestDto requestDto, Long id) {
        Order order = requestMapper.fromDto(requestDto);
        order.setId(id);
        return responseMapper.toDto(orderService.save(order));
    }

    /*
    * • GET - Get this customer's orders
• POST - Adding "Product" to the "Order" entity
• PUT - Editing the status of the "Order"
• GET - Calculation of the cost of the "Order"
    * */
}
