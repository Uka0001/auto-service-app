package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.GoodRequestMapper;
import com.example.autoservice.dto.mapper.request.OrderRequestMapper;
import com.example.autoservice.dto.mapper.response.OrderResponseMapper;
import com.example.autoservice.dto.request.GoodRequestDto;
import com.example.autoservice.dto.request.OrderRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Good;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.OrderStatus;
import com.example.autoservice.service.OrderService;
import com.example.autoservice.service.OwnerService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersControllers {
    private final OrderService orderService;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderRequestMapper orderRequestMapper;
    private final OwnerService ownerService;
    private final GoodRequestMapper goodRequestMapper;

    public OrdersControllers(OrderService orderService,
                             OrderResponseMapper responseMapper,
                             OrderRequestMapper requestMapper,
                             OwnerService ownerService,
                             GoodRequestMapper goodRequestMapper) {
        this.orderService = orderService;
        this.orderResponseMapper = responseMapper;
        this.orderRequestMapper = requestMapper;
        this.ownerService = ownerService;
        this.goodRequestMapper = goodRequestMapper;
    }

    @PostMapping
    public OrderResponseDto add(@RequestBody OrderRequestDto dto) {
        Order order = orderService.save(orderRequestMapper.fromDto(dto));
        return orderResponseMapper.toDto(order);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@RequestBody OrderRequestDto requestDto,
                                   @PathVariable Long id) {
        Order order = orderRequestMapper.fromDto(requestDto);
        order.setId(id);
        return orderResponseMapper.toDto(orderService.save(order));
    }

    @PutMapping("/{id}/{status}")
    public OrderResponseDto updateOrderStatus(@RequestBody OrderRequestDto requestDto,
                                              @PathVariable Long id,
                                              @PathVariable OrderStatus status) {
        Order order = orderRequestMapper.fromDto(requestDto);
        order.setStatus(status);
        order.setId(id);
        return orderResponseMapper.toDto(orderService.save(order));
    }

    @GetMapping("/orders")
    public List<Order> getOwnerOrders(Long customerId) {
        return ownerService.get(customerId).getOrders();
    }

    @PostMapping("/product")
    public OrderResponseDto addProduct(@RequestBody OrderRequestDto orderRequestDto,
                                       @RequestBody GoodRequestDto goodRequestDto) {
        Order order = orderRequestMapper.fromDto(orderRequestDto);
        Good good = goodRequestMapper.fromDto(goodRequestDto);
        List<Good> goodsList = order.getGoodsList();
        goodsList.add(good);
        order.setGoodsList(goodsList);
        return orderResponseMapper.toDto(order);
    }

    @GetMapping("/cost")
    public BigDecimal getOrderCost(Long orderId) {
        return orderService.calculate(orderService.getOrderById(orderId));
    }
}
