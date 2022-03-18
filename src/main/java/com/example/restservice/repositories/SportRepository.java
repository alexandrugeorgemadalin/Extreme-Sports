package com.example.restservice.repositories;

import com.example.restservice.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface SportRepository extends JpaRepository<Sport, Long> {

    @Query(value = "SELECT DISTINCT q FROM Sport q WHERE LOWER(q.name) = LOWER(?1)")
    Sport findByName(String name);

    @Query(value = "SELECT DISTINCT s FROM Sport s WHERE s.dailyCost = ?1")
    List<Sport> findByCost(Integer cost);

    @Query(value = "SELECT s FROM Sport s WHERE s.startDate < ?1 AND s.endDate > ?2")
    List<Sport> findByPeriod(Date startDate, Date endDate);

    @Query(value = "SELECT DISTINCT s FROM Sport s WHERE LOWER(s.name) = LOWER(?1) AND s.startDate < ?2 AND s.endDate > ?3")
    Sport findByNameAndPeriod(String name, Date startDate, Date endDate);

    @Query(value = "SELECT DISTINCT s FROM Sport s WHERE s.name IN (:sports)")
    List<Sport> findByListOfSports(List<String> sports);

    @Query(value = "SELECT DISTINCT s FROM Sport s WHERE s.dailyCost BETWEEN ?1 AND ?2")
    List<Sport> findByCostRange(Integer min, Integer max);
}
