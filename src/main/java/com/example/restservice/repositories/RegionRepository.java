package com.example.restservice.repositories;

import com.example.restservice.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    @Query(value = "SELECT DISTINCT q FROM Region q WHERE LOWER(q.name) = LOWER(?1)")
    Region findByName(String name);

    @Query(value = "SELECT DISTINCT s FROM Region s WHERE s.name IN (:regions)")
    List<Region> findByListOfRegions(List<String> regions);
}
