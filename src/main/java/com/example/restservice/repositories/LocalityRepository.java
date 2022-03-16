package com.example.restservice.repositories;

import com.example.restservice.domain.Locality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
}
