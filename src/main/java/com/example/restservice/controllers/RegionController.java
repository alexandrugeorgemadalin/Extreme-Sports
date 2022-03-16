package com.example.restservice.controllers;

import com.example.restservice.domain.Country;
import com.example.restservice.domain.Region;
import com.example.restservice.dto.RegionDto;
import com.example.restservice.services.RegionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(RegionController.BASE_URL)
public class RegionController extends AbstractController<Region, RegionDto, Long> {
    public static final String BASE_URL = "api/v1/regions";

    private final RegionServiceImpl service;

    public RegionController(RegionServiceImpl serviceBean) {
        super(serviceBean);
        this.service = serviceBean;
    }

    @GetMapping(value = "/find", params = {"name"})
    public ResponseEntity<Region> getCountryByName(@RequestParam("name") String name) {
        try {
            return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
