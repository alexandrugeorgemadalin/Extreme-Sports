package com.example.restservice.controllers;

import com.example.restservice.domain.Locality;
import com.example.restservice.dto.LocalityDto;
import com.example.restservice.services.LocalityServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LocalityController.BASE_URL)
public class LocalityController extends AbstractController<Locality, LocalityDto, Long> {

    public static final String BASE_URL = "api/v1/localities";

    private final LocalityServiceImpl service;

    public LocalityController(LocalityServiceImpl serviceBean) {
        super(serviceBean);
        this.service = serviceBean;
    }
}
