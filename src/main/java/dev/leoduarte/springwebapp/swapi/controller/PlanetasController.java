package dev.leoduarte.springwebapp.swapi.controller;

import dev.leoduarte.springwebapp.swapi.dto.Planet;
import dev.leoduarte.springwebapp.swapi.service.PlanetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlanetasController {

    private final PlanetsService service;

    @GetMapping("/planetas/listar")
    public List<Planet> getAllPlanets() {
        return service.getPlanets();
    }

    @GetMapping("/planetas/{id}")
    public Planet getPlanetById(@PathVariable Long id) {
        return service.getPlanet(id);
    }
}
