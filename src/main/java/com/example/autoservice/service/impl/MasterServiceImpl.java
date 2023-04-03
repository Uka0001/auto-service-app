package com.example.autoservice.service.impl;

import java.math.BigDecimal;
import com.example.autoservice.model.Master;
import com.example.autoservice.repository.MasterRepository;
import com.example.autoservice.service.MasterService;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    MasterRepository masterRepository;

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
}
