package dev.leoduarte.springwebapp.swapi.service;

import dev.leoduarte.springwebapp.swapi.dto.Planet;
import dev.leoduarte.springwebapp.swapi.openfeign.SwapiPlanetsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanetsService {

    private final SwapiPlanetsClient client;

    public List<Planet> getPlanets() {
        return client.getPlanets();
    }

    public Planet getPlanet(Long id) {
        return client.getPlanet(id);
    }

}
