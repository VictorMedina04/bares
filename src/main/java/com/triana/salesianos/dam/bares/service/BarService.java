package com.triana.salesianos.dam.bares.service;

import com.triana.salesianos.dam.bares.models.Bar;
import com.triana.salesianos.dam.bares.repository.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarService {

    @Autowired
    private BarRepository barRepository;

    public BarService(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    public List<Bar> findAll() {
        return barRepository.findAll();
    }

    public Optional<Bar>  findById(Long id) {
        return  barRepository.findById(id);
    }

    public Bar save(Bar bar) {
        return barRepository.save(bar);
    }

    public Bar update(Bar bar, Long id) {
        Bar barEncontrado = barRepository.findById(id).orElse(null);

        if (barEncontrado != null) {
            return barRepository.save(barEncontrado);
        }
        return barRepository.save(bar);
    }

    public void deleteById(Long id) {
        barRepository.delete(findById(id).get());

    }


}
