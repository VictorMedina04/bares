package com.triana.salesianos.dam.bares.service;

import com.triana.salesianos.dam.bares.models.Tag;
import com.triana.salesianos.dam.bares.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {


    @Autowired
    private final TagRepository repo;


    public List<Tag> getAll() {
        return repo.findAll();
    }


    public Tag getTagById(Long id) {
        return repo.findById(id).orElse(null);
    }


    public void deleteTagById(Long id) {
        repo.deleteById(id);
    }


    public Tag modificarTag(Tag t, Long id) {
        Tag tagEncontrado = repo.findById(id).orElse(null);
        if (tagEncontrado != null) {
            return repo.save(t);
        }
        return t;
    }


    public Tag guardarTag(Tag t) {
        return repo.save(t);
    }


}

