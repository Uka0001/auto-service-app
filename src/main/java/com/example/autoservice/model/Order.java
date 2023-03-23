package com.example.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;
    private String description;
    private LocalDate dateOfAdoption;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Service> serviceList;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Good> goodsList;
    private OrderStatus status;
    private BigDecimal totalCost;
}
