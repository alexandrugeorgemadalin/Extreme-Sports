package com.example.restservice.services;

import com.example.restservice.domain.Country;
import com.example.restservice.dto.CountryDto;
import com.example.restservice.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class CountryServiceImpl extends AbstractService<Country, CountryDto, Long> implements EntityService<Country, CountryDto, Long> {

    @Autowired
    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository repository) {
        super(repository);
        this.countryRepository = repository;
    }

    @Override
    protected Country dtoToEntity(CountryDto countryDto) {
        return new Country(countryDto.getName());
    }

    @Override
    protected Country updateEntityFromDto(Country toUpdate, CountryDto countryDto) {
        toUpdate.setName(countryDto.getName());
        return toUpdate;
    }

    public Country findByName(String name) {
        var response = countryRepository.findByName(name);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
