package com.example.autoservice.service;

import com.example.autoservice.model.Master;

import java.math.BigDecimal;

public interface MasterService {
    Master save(Master master);
    Master update(Master master);
    BigDecimal getSalary(Master master);
}
