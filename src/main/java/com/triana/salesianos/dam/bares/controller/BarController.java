package com.triana.salesianos.dam.bares.controller;

import com.triana.salesianos.dam.bares.BaresApplication;
import com.triana.salesianos.dam.bares.models.Bar;
import com.triana.salesianos.dam.bares.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class BarController {

    private final BarService barService;
    private final BaresApplication baresApplication;

    @GetMapping("/")
    public ResponseEntity<List<Bar>> index() {

<<<<<<< HEAD
        List<Bar>listaBares = barService.findAll();


        if (listaBares.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaBares, HttpStatus.OK);

        //return listaBares != null ? new ResponseEntity<>(listaBares, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.CREATED);
        //return new ResponseEntity<>(barService.findAll(), HttpStatus.OK);
=======
        if (barService.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(barService.findAll(), HttpStatus.OK);
>>>>>>> c65935d1346eaa21e7acce37f6e920a079347a6b
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bar> findById(@PathVariable Long id) {
        Optional<Bar> bar = barService.findById(id);
        return bar != null ? new ResponseEntity<>(bar.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Bar> create(@RequestBody Bar bar) {
        return new ResponseEntity<>(barService.save(bar), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bar> update(@PathVariable Long id, @RequestBody Bar bar) {

        return ResponseEntity.of(
                barService.findById(id).map(
                        barEditar -> {
                            barEditar.setLatitud(bar.getLatitud());
                            barEditar.setLongitud(bar.getLongitud());
                            barEditar.setNombre(bar.getNombre());
                            barEditar.setDireccion(bar.getDireccion());
                            barEditar.setDescripcion(bar.getDescripcion());
                            barEditar.setUrlImagen(bar.getUrlImagen());
                            return barService.save(barEditar);
                        })
        );


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        barService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/tag/add/{nuevo_tag}")
    public ResponseEntity<Void> addTag(@PathVariable Long id, @PathVariable String nuevo_tag) {

        Optional<Bar> bar = barService.findById(id);


    }
}
