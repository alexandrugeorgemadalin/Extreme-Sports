package com.example.restservice.repositories;

import com.example.restservice.domain.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalityRepository extends JpaRepository<Locality, Long> {

    @Query(value = "SELECT DISTINCT q FROM Locality q WHERE LOWER(q.name) = LOWER(?1)")
    Locality findByName(String name);

    @Query(value = "SELECT DISTINCT s FROM Locality s WHERE s.name IN (:localities)")
    List<Locality> findByListOfLocalities(List<String> localities);
}
