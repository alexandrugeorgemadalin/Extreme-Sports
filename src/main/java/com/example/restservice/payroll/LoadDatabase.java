package com.example.restservice.payroll;

import com.example.restservice.domain.Country;
import com.example.restservice.repositories.CountryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initCountryDatabase(CountryRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Country("Romania")));
            log.info("Preloading " + repository.save(new Country("Austria")));
            log.info("Preloading " + repository.save(new Country("Italia")));
        };
    }

}
