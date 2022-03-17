package com.example.restservice.controllers;

import com.example.restservice.domain.Sport;
import com.example.restservice.dto.SportDto;
import com.example.restservice.services.SportServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(SportController.BASE_URL)
public class SportController extends AbstractController<Sport, SportDto, Long> {
    public static final String BASE_URL = "api/v1/sports";

    private final SportServiceImpl service;

    public SportController(SportServiceImpl serviceBean) {
        super(serviceBean);
        this.service = serviceBean;
    }

    @GetMapping(value = "/find", params = {"name"})
    public ResponseEntity<Sport> getSportByName(@RequestParam("name") String name) {
        try {
            return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/find", params = {"cost"})
    public ResponseEntity<List<Sport>> getSportByCost(@RequestParam("cost") Integer cost) {
        try {
            var entities = service.findByCost(cost);
            return new ResponseEntity<>(entities, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/find", params = {"startDate", "endDate"})
    public ResponseEntity<List<Sport>> getSportByPeriod(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                        @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        try {
            var entities = service.findByPeriod(startDate, endDate);
            return new ResponseEntity<>(entities, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/find", params = {"name", "startDate", "endDate"})
    public ResponseEntity<Sport> getSportByNameAndPeriod(@RequestParam("name") String name,
                                                         @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                         @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        try {
            var entity = service.findByNameAndPeriod(name, startDate, endDate);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/find", params = {"sports"})
    public ResponseEntity<List<Sport>> getSportByListOfSports(@RequestParam List<String> sports) {
        try {
            var entities = service.findByListOfSports(sports);
            return new ResponseEntity<>(entities, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/find/cost/range", params = {"min", "max"})
    public ResponseEntity<List<Sport>> getSportByCostRange(@RequestParam("min") Integer min, @RequestParam("max") Integer max) {
        try {
            var entities = service.findByCostRange(min, max);
            return new ResponseEntity<>(entities, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
