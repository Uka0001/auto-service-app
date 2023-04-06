package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.ServiceResponseDto;
import com.example.autoservice.model.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceResponseMapper
        implements DtoResponseMapper<ServiceResponseDto, Service> {
    @Override
    public ServiceResponseDto toDto(Service service) {
        ServiceResponseDto serviceResponseDto = new ServiceResponseDto();
        serviceResponseDto.setStatus(service.getStatus());
        serviceResponseDto.setOrder(service.getOrder());
        serviceResponseDto.setPrice(service.getPrice());
        serviceResponseDto.setMaster(service.getMaster());
        return serviceResponseDto;
    }
}
