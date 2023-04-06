package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.ServiceRequestDto;
import com.example.autoservice.model.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceRequestMapper
        implements DtoRequestMapper<ServiceRequestDto, Service> {
    @Override
    public Service fromDto(ServiceRequestDto dto) {
        Service service = new Service();
        service.setStatus(dto.getStatus());
        service.setOrder(dto.getOrder());
        service.setStatus(dto.getStatus());
        service.setMaster(dto.getMaster());
        return service;
    }
}
