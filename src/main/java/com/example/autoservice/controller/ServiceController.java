package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.ServiceRequestMapper;
import com.example.autoservice.dto.mapper.response.ServiceResponseMapper;
import com.example.autoservice.dto.request.ServiceRequestDto;
import com.example.autoservice.dto.response.ServiceResponseDto;
import com.example.autoservice.model.Service;
import com.example.autoservice.model.ServiceStatus;
import com.example.autoservice.service.ServiceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService serviceService;
    private final ServiceResponseMapper responseMapper;
    private final ServiceRequestMapper requestMapper;

    public ServiceController(ServiceService serviceService,
                             ServiceResponseMapper responseMapper,
                             ServiceRequestMapper requestMapper) {
        this.serviceService = serviceService;
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
    }

    @PostMapping
    public ServiceResponseDto add(@RequestBody ServiceRequestDto dto) {
        Service service = serviceService.save(requestMapper.fromDto(dto));
        return responseMapper.toDto(service);
    }

    @PutMapping("/{id}")
    public ServiceResponseDto update(@RequestBody ServiceRequestDto requestDto,
                                            @PathVariable Long id) {
        Service service = requestMapper.fromDto(requestDto);
        service.setId(id);
        return responseMapper.toDto(serviceService.save(service));
    }

    @PutMapping("/{id}/{status}")
    public ServiceResponseDto updateServiceStatus(@PathVariable Long id,
                                                  @PathVariable ServiceStatus status) {
        Service service = serviceService.getById(id);
        service.setStatus(status);
        service.setId(id);
        return responseMapper.toDto(serviceService.save(service));
    }
}
