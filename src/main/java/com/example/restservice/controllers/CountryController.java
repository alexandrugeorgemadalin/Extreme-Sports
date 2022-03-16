package com.example.restservice.controllers;

import com.example.restservice.domain.Country;
import com.example.restservice.dto.CountryDto;
import com.example.restservice.services.CountryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(CountryController.BASE_URL)
public class CountryController extends AbstractController<Country, CountryDto, Long> {
    public static final String BASE_URL = "api/v1/countries";

    private final CountryServiceImpl service;

    public CountryController(CountryServiceImpl countryService) {
        super(countryService);
        this.service = countryService;
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<Country> getCountryByName(@RequestParam("name") String name) {
        try {
            return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
