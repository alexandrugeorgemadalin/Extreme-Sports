package com.example.restservice.services;

import com.example.restservice.domain.Locality;
import com.example.restservice.domain.Sport;
import com.example.restservice.dto.LocalityDto;
import com.example.restservice.dto.SportDto;
import com.example.restservice.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.lang.module.ResolutionException;

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
}
