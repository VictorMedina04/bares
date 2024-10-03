package com.triana.salesianos.dam.bares.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bar {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nombre, direccion, descripcion, urlImagen;

    @Column(nullable = false)
    private double latitud, longitud;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bar_tag", joinColumns = @JoinColumn(name = "idBar"),
            inverseJoinColumns = @JoinColumn(name = "idTag"))
    @JsonIgnoreProperties("listaBares")
    private List<Tag> listaTags;

    public void setTag(Tag tag) {
        if (this.listaTags == null) {
            this.listaTags = new ArrayList<>();
        }
        this.listaTags.add(tag);
    }

}
