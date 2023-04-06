package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.MasterRequestDto;
import com.example.autoservice.model.Master;
import org.springframework.stereotype.Component;

@Component
public class MasterRequestMapper
        implements DtoRequestMapper<MasterRequestDto, Master> {
    @Override
    public Master fromDto(MasterRequestDto dto) {
        Master master = new Master();
        master.setFullName(dto.getFullName());
        master.setCompletedOrder(dto.getCompletedOrder());
        return master;
    }
}
