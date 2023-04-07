package com.example.autoservice.service.impl;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.repository.MasterRepository;
import com.example.autoservice.service.MasterService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private MasterRepository masterRepository;

    @Override
    public Master save(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master update(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public BigDecimal getSalary(Master master) {
        return masterRepository
                .getReferenceById(master.getId())
                .getCompletedOrder()
                .stream()
                .map(order -> order.getTotalCost())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<Order> getMastersOrders(Long masterId) {
        return masterRepository.getReferenceById(masterId).getCompletedOrder();
    }

    @Override
    public Master findById(Long masterId) {
        return masterRepository.findById(masterId).orElseThrow();
    }
}
