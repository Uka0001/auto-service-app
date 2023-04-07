package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.OwnerRequestMapper;
import com.example.autoservice.dto.mapper.response.OwnerResponseMapper;
import com.example.autoservice.dto.request.OwnerRequestDto;
import com.example.autoservice.dto.response.OwnerResponseDto;
import com.example.autoservice.model.Owner;
import com.example.autoservice.service.OwnerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final OwnerResponseMapper ownerResponseMapper;
    private final OwnerRequestMapper ownerRequestMapper;

    public OwnerController(OwnerService ownerService,
                           OwnerResponseMapper ownerResponseMapper,
                           OwnerRequestMapper ownerRequestMapper) {
        this.ownerService = ownerService;
        this.ownerResponseMapper = ownerResponseMapper;
        this.ownerRequestMapper = ownerRequestMapper;
    }

    @PostMapping
    public OwnerResponseDto add(@RequestBody OwnerRequestDto dto) {
        Owner owner = ownerService.save(ownerRequestMapper.fromDto(dto));
        return ownerResponseMapper.toDto(owner);
    }

    @PutMapping("/{id}")
    public OwnerResponseDto update(@RequestBody OwnerRequestDto requestDto,
                                        @PathVariable Long id) {
        Owner owner = ownerRequestMapper.fromDto(requestDto);
        owner.setId(id);
        return ownerResponseMapper.toDto(ownerService.save(owner));
    }
}
