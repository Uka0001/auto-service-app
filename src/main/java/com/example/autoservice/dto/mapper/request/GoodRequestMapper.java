package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.GoodRequestDto;
import com.example.autoservice.model.Good;

public class GoodRequestMapper implements DtoRequestMapper<GoodRequestDto, Good> {
    @Override
    public Good fromDto(GoodRequestDto dto) {
        Good good = new Good();
        good.setName(dto.getName());
        good.setGoodCost(dto.getGoodCost());
        good.setOrder(dto.getOrder());
        return good;
    }
}
