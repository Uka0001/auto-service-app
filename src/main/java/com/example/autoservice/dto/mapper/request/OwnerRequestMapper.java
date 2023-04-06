package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.OwnerRequestDto;
import com.example.autoservice.model.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerRequestMapper
        implements DtoRequestMapper<OwnerRequestDto, Owner> {
    @Override
    public Owner fromDto(OwnerRequestDto dto) {
        Owner owner = new Owner();
        owner.setOwnerName(dto.getOwnerName());
        owner.setCars(dto.getCars());
        owner.setOrders(dto.getOrders());
        return owner;
    }
}
