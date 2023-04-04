package com.example.autoservice.controller;

import com.example.autoservice.service.GoodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/goods")
public class GoodController {
    private final GoodService goodService;
    private final GoodRequestMapper requestMapper;
    private final GoodResponseMapper responseMapper;

    public GoodController(GoodService goodService,
                          GoodRequestMapper requestMapper,
                          GoodResponseMapper responseMapper) {
        this.goodService = goodService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    /*
    * • POST - Creation of the entity "Goods"
• PUT - Editing entity data
    * */
}
