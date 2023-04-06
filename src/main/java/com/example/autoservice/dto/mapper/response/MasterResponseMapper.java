package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.MasterResponseDto;
import com.example.autoservice.model.Master;
import org.springframework.stereotype.Component;

@Component
public class MasterResponseMapper
        implements DtoResponseMapper<MasterResponseDto, Master> {
    @Override
    public MasterResponseDto toDto(Master master) {
        MasterResponseDto masterResponseDto = new MasterResponseDto();
        masterResponseDto.setCompletedOrder(master.getCompletedOrder());
        masterResponseDto.setFullName(master.getFullName());
        return null;
    }
}
