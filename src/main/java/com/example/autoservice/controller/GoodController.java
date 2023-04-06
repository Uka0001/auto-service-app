package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.GoodRequestMapper;
import com.example.autoservice.dto.mapper.response.GoodResponseMapper;
import com.example.autoservice.dto.request.GoodRequestDto;
import com.example.autoservice.dto.response.GoodResponseDto;
import com.example.autoservice.model.Good;
import com.example.autoservice.service.GoodService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/add_good")
    public GoodResponseDto addGood(@RequestBody GoodRequestDto dto) {
        Good good = goodService.save(requestMapper.fromDto(dto));
        return responseMapper.toDto(good);
    }

    @PutMapping("/update_good")
    public GoodResponseDto updateGood(@RequestBody GoodRequestDto dto, Long id) {
        Good good = requestMapper.fromDto(dto);
        good.setId(id);
        return responseMapper.toDto(goodService.save(good));
    }
}
