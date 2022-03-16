package com.example.restservice.repositories;

import com.example.restservice.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "SELECT DISTINCT q FROM Country q WHERE LOWER(q.name) = LOWER(?1)")
    Country findByName(String name);
}
