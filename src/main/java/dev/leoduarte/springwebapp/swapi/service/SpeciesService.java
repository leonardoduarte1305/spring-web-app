package dev.leoduarte.springwebapp.swapi.service;

import dev.leoduarte.springwebapp.swapi.dto.Specie;
import dev.leoduarte.springwebapp.swapi.openfeign.SwapiSpeciesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpeciesService {

    private final SwapiSpeciesClient client;

    @GetMapping
    public List<Specie> getAllSpecies() {
        return client.getSpecies();
    }

    @GetMapping("/{id}")
    public Specie getSpeciesById(@PathVariable Long id) {
        return client.getSpecie(id);
    }
}
