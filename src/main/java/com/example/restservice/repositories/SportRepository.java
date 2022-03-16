package com.example.restservice.repositories;

import com.example.restservice.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SportRepository extends JpaRepository<Sport, Long> {
}
