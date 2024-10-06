package com.triana.salesianos.dam.bares.controller;

import com.triana.salesianos.dam.bares.models.Bar;
import com.triana.salesianos.dam.bares.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class BarController {

    private final BarService barService;

    @GetMapping("/")
    public ResponseEntity<List<Bar>> index() {

        List<Bar>listaBares = barService.findAll();


        if (listaBares.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaBares, HttpStatus.OK);

        //return listaBares != null ? new ResponseEntity<>(listaBares, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.CREATED);
        //return new ResponseEntity<>(barService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bar> findById(@PathVariable Long id) {
        Bar bar = barService.findById(id);
        return bar != null ? new ResponseEntity<>(bar, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/")
    public ResponseEntity<Bar> create(@RequestBody Bar bar) {
        return new ResponseEntity<>(barService.save(bar), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bar> update(@PathVariable Long id, @RequestBody Bar bar) {
        return ResponseEntity.ok(barService.update(bar, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        barService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
