package dev.leoduarte.springwebapp.swapi.openfeign;

import dev.leoduarte.springwebapp.swapi.dto.Planet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "planets", url = "https://swapi.dev/api/planets", primary = false)
public interface SwapiPlanetsClient {

    @GetMapping
    List<Planet> getPlanets();

    @GetMapping("/{id}")
    Planet getPlanet(@PathVariable("id") Long id);

}
