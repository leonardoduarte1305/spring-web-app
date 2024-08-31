package dev.leoduarte.springwebapp.swapi.controller;

import dev.leoduarte.springwebapp.swapi.dto.Starship;
import dev.leoduarte.springwebapp.swapi.service.StarshipsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NavesEstelaresController {

    private final StarshipsService service;

    @GetMapping("/naves-estelares/listar")
    public List<Starship> getAllStarships() {
        return service.getStarships();
    }

    @GetMapping("/naves-estelares/{id}")
    public Starship getStarshipById(@PathVariable Long id) {
        return service.getStarship(id);
    }

}
