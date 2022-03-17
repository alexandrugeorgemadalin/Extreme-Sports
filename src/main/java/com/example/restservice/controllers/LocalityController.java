package com.example.restservice.controllers;

import com.example.restservice.domain.Locality;
import com.example.restservice.dto.LocalityDto;
import com.example.restservice.services.LocalityServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(LocalityController.BASE_URL)
public class LocalityController extends AbstractController<Locality, LocalityDto, Long> {

    public static final String BASE_URL = "api/v1/localities";

    private final LocalityServiceImpl service;

    public LocalityController(LocalityServiceImpl serviceBean) {
        super(serviceBean);
        this.service = serviceBean;
    }

    @GetMapping(value = "/find", params = {"name"})
    public ResponseEntity<Locality> getCountryByName(@RequestParam("name") String name) {
        try {
            return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/find", params = {"localities"})
    public ResponseEntity<List<Locality>> getLocalityByListOfLocalities(@RequestParam List<String> localities) {
        try {
            var entities = service.findByListOfLocalities(localities);
            return new ResponseEntity<>(entities, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
