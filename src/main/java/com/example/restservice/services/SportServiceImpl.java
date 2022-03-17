package com.example.restservice.services;

import com.example.restservice.domain.Locality;
import com.example.restservice.domain.Sport;
import com.example.restservice.dto.LocalityDto;
import com.example.restservice.dto.SportDto;
import com.example.restservice.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.lang.module.ResolutionException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SportServiceImpl extends AbstractService<Sport, SportDto, Long> implements EntityService<Sport, SportDto, Long> {

    @Autowired
    private final SportRepository sportRepository;

    @Autowired
    private EntityService<Locality, LocalityDto, Long> localityService;

    @Autowired
    public SportServiceImpl(SportRepository repository, EntityService<Locality, LocalityDto, Long> localityService) {
        super(repository);
        this.sportRepository = repository;
        this.localityService = localityService;
    }

    @Override
    protected Sport dtoToEntity(SportDto sportDto) {
        try {
            var locality = this.localityService.findById(sportDto.getLocalityID());
            return new Sport(sportDto.getName(), locality,
                    sportDto.getDailyCost(), sportDto.getStartDate(), sportDto.getEndDate());
        } catch (ResolutionException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    protected Sport updateEntityFromDto(Sport toUpdate, SportDto sportDto) {
        toUpdate.setName(sportDto.getName());
        if (toUpdate.getLocality().getId().equals(sportDto.getLocalityID())) {
            return toUpdate;
        }
        try {
            var newLocality = this.localityService.findById(sportDto.getLocalityID());
            toUpdate.setLocality(newLocality);
            return toUpdate;
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Sport findByName(String name) {
        var response = sportRepository.findByName(name);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public List<Sport> findByCost(Integer cost) {
        var response = sportRepository.findByCost(cost);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public List<Sport> findByPeriod(Date startDate, Date endDate) {
        var response = sportRepository.findByPeriod(startDate, endDate);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public Sport findByNameAndPeriod(String name, Date startDate, Date endDate) {
        var response = sportRepository.findByNameAndPeriod(name, startDate, endDate);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public List<Sport> findByListOfSports(List<String> sports) {
        var response = sportRepository.findByListOfSports(sports);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public List<Sport> findByCostRange(Integer min, Integer max) {
        var response = sportRepository.findByCostRange(min, max);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
