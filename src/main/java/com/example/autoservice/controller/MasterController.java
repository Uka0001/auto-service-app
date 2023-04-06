package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.MasterRequestMapper;
import com.example.autoservice.dto.mapper.response.MasterResponseMapper;
import com.example.autoservice.dto.request.MasterRequestDto;
import com.example.autoservice.dto.response.MasterResponseDto;
import com.example.autoservice.model.Master;
import com.example.autoservice.service.MasterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/masters")
public class MasterController {
    private final MasterService masterService;
    private final MasterRequestMapper requestMapper;
    private final MasterResponseMapper responseMapper;

    public MasterController(MasterService masterService,
                            MasterRequestMapper requestMapper,
                            MasterResponseMapper responseMapper) {
        this.masterService = masterService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/add_master")
    public MasterResponseDto addAMaster(@RequestBody MasterRequestDto dto) {
        Master master = masterService.save(requestMapper.fromDto(dto));
        return responseMapper.toDto(master);
    }

    @PutMapping("/update_master")
    public MasterResponseDto update(MasterRequestDto requestDto, Long id) {
        Master master = requestMapper.fromDto(requestDto);
        master.setId(id);
        return responseMapper.toDto(masterService.save(master));
    }



    /*
• GET - Receiving master's orders
• GET - Calculation and issuance of wages to the master
    * */
}
