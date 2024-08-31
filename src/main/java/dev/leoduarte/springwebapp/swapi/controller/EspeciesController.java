package dev.leoduarte.springwebapp.swapi.controller;

import dev.leoduarte.springwebapp.swapi.dto.Specie;
import dev.leoduarte.springwebapp.swapi.service.SpeciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EspeciesController {

    private final SpeciesService service;

    @GetMapping("/especies/listar")
    public List<Specie> getAllSpecies() {
        return service.getAllSpecies();
    }

    @GetMapping("/especies/{id}")
    public Specie getSpecieById(@PathVariable Long id) {
        return service.getSpeciesById(id);
    }
}
