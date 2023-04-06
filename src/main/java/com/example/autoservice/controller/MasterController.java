package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.MasterRequestMapper;
import com.example.autoservice.dto.mapper.response.MasterResponseMapper;
import com.example.autoservice.service.MasterService;
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

    /*
• POST - Creation of the "Master" entity
• PUT - Editing entity data
• GET - Receiving master's orders
• GET - Calculation and issuance of wages to the master
    * */
}
