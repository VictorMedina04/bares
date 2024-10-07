package com.triana.salesianos.dam.bares.controller;

import com.triana.salesianos.dam.bares.BaresApplication;
import com.triana.salesianos.dam.bares.models.Bar;
import com.triana.salesianos.dam.bares.models.Tag;
import com.triana.salesianos.dam.bares.service.BarService;
import com.triana.salesianos.dam.bares.service.TagService;
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

    private final TagService tagService;

    @GetMapping("/")
    public ResponseEntity<List<Bar>> index() {

        if (barService.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(barService.findAll(), HttpStatus.OK);

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

    @PutMapping("/{id}/tag/add/{idTag}")
    public ResponseEntity<Bar> addTag(@PathVariable Long id, @PathVariable Long idTag) {

        Optional<Bar> bar = barService.findById(id);
        Tag nuevoTag = tagService.getTagById(idTag);

        if (nuevoTag == null && !bar.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return ResponseEntity.ok(barService.addTag(bar.get(), nuevoTag));
    }

    @PutMapping("/{id}/tag/del/{idTag}")
    public ResponseEntity<Bar> eliminarTag(@PathVariable Long id, @PathVariable Long idTag) {

        Optional<Bar> bar = barService.findById(id);

        Tag tagEncontrada = tagService.getTagById(idTag);
        

        bar.get().getListaTags().remove(tagEncontrada);
        barService.save(bar.get());



        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
