package com.triana.salesianos.dam.bares.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "listaTags")
    @JsonIgnoreProperties("listaTags")
    private List<Bar> listaBares;
}
