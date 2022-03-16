package com.example.restservice.controllers;

import com.example.restservice.domain.Sport;
import com.example.restservice.dto.SportDto;
import com.example.restservice.services.SportServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SportController.BASE_URL)
public class SportController extends AbstractController<Sport, SportDto, Long> {
    public static final String BASE_URL = "api/v1/sports";

    private final SportServiceImpl service;

    public SportController(SportServiceImpl serviceBean) {
        super(serviceBean);
        this.service = serviceBean;
    }
}
