package com.example.autoservice.service.impl;

import com.example.autoservice.model.Good;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.OrderStatus;
import com.example.autoservice.model.Owner;
import com.example.autoservice.repository.GoodRepository;
import com.example.autoservice.repository.OrderRepository;
import com.example.autoservice.repository.OwnerRepository;
import com.example.autoservice.service.OrderService;
import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final GoodRepository goodRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByOwner(Owner owner) {
        return ownerRepository
                .getReferenceById(owner.getId())
                .getOrders();
    }

    @Override
    public Order updateByGood(Good good, Order order) {
        List<Good> goods = order.getGoodsList();
        goods.add(good);
        order.setGoodsList(goods);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order updatedOrder, Long updatedOrderId) {
        updatedOrder.setId(updatedOrderId);
        return orderRepository.save(updatedOrder);
    }

    @Override
    public Order updateByStatus(OrderStatus status, Long updatedOrderId) {
        Order order = orderRepository.getReferenceById(updatedOrderId);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public BigDecimal calculate(Order order) {
        BigDecimal goodCost = order.getGoodsList()
                .stream()
                .map(Good::getGoodCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal serviceCost = order.getServiceList()
                .stream()
                .map(com.example.autoservice.model.Service::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return goodCost.add(serviceCost);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.getReferenceById(orderId);
    }
}
