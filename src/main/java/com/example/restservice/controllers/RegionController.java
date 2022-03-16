package com.example.restservice.controllers;

import com.example.restservice.domain.Region;
import com.example.restservice.dto.RegionDto;
import com.example.restservice.services.RegionServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RegionController.BASE_URL)
public class RegionController extends AbstractController<Region, RegionDto, Long> {
    public static final String BASE_URL = "api/v1/regions";

    private final RegionServiceImpl service;

    public RegionController(RegionServiceImpl serviceBean) {
        super(serviceBean);
        this.service = serviceBean;
    }
}
