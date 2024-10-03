package com.triana.salesianos.dam.bares.repository;

import com.triana.salesianos.dam.bares.models.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {
}
