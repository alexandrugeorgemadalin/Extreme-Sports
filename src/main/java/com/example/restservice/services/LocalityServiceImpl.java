package com.example.restservice.services;

import com.example.restservice.domain.Country;
import com.example.restservice.domain.Locality;
import com.example.restservice.domain.Region;
import com.example.restservice.dto.LocalityDto;
import com.example.restservice.dto.RegionDto;
import com.example.restservice.repositories.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.lang.module.ResolutionException;

@Service
@Transactional
public class LocalityServiceImpl extends AbstractService<Locality, LocalityDto, Long> implements EntityService<Locality, LocalityDto, Long> {

    @Autowired
    private final LocalityRepository localityRepository;

    @Autowired
    private EntityService<Region, RegionDto, Long> regionService;

    @Autowired
    public LocalityServiceImpl(LocalityRepository repository,
                               EntityService<Region, RegionDto, Long> regionService) {
        super(repository);
        this.localityRepository = repository;
        this.regionService = regionService;
    }

    @Override
    protected Locality dtoToEntity(LocalityDto localityDto) {
        try {
            var region = this.regionService.findById(localityDto.getRegionID());
            return new Locality(localityDto.getName(), region);
        } catch (ResolutionException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    protected Locality updateEntityFromDto(Locality toUpdate, LocalityDto localityDto) {
        toUpdate.setName(localityDto.getName());
        if (toUpdate.getRegion().getId().equals(localityDto.getRegionID())) {
            return toUpdate;
        }
        try {
            var newRegion = this.regionService.findById(localityDto.getRegionID());
            toUpdate.setRegion(newRegion);
            return toUpdate;
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Locality findByName(String name) {
        var response = localityRepository.findByName(name);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
