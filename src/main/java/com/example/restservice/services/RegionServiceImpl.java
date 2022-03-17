package com.example.restservice.services;

import com.example.restservice.domain.Country;
import com.example.restservice.domain.Region;
import com.example.restservice.dto.CountryDto;
import com.example.restservice.dto.RegionDto;
import com.example.restservice.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegionServiceImpl extends AbstractService<Region, RegionDto, Long> implements EntityService<Region, RegionDto, Long> {

    @Autowired
    private final RegionRepository regionRepository;

    private EntityService<Country, CountryDto, Long> countryService;

    @Autowired
    public RegionServiceImpl(RegionRepository repository, EntityService<Country, CountryDto, Long> countryService) {
        super(repository);
        this.regionRepository = repository;
        this.countryService = countryService;
    }


    @Override
    protected Region dtoToEntity(RegionDto regionDto) {
        try {
            var country = this.countryService.findById(regionDto.getCountryID());
            return new Region(regionDto.getName(), country);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    protected Region updateEntityFromDto(Region toUpdate, RegionDto regionDto) {
        toUpdate.setName(regionDto.getName());
        if (toUpdate.getCountry().getId().equals(regionDto.getCountryID())) {
            return toUpdate;
        }

        try {
            var newCountry = this.countryService.findById(regionDto.getCountryID());
            toUpdate.setCountry(newCountry);
            return toUpdate;
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Region findByName(String name) {
        var response = regionRepository.findByName(name);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public List<Region> findByListOfRegions(List<String> regions) {
        var response = regionRepository.findByListOfRegions(regions);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }

}


