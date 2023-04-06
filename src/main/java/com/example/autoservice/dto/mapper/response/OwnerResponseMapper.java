package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.OwnerResponseDto;
import com.example.autoservice.model.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerResponseMapper
        implements DtoResponseMapper<OwnerResponseDto, Owner> {
    @Override
    public OwnerResponseDto toDto(Owner owner) {
        OwnerResponseDto responseDto = new OwnerResponseDto();
        responseDto.setOwnerName(owner.getOwnerName());
        responseDto.setCars(owner.getCars());
        responseDto.setOrders(owner.getOrders());
        return responseDto;
    }
}
