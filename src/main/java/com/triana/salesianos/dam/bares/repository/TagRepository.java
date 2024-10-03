package com.triana.salesianos.dam.bares.repository;

import com.triana.salesianos.dam.bares.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
