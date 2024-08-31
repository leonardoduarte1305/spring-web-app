package dev.leoduarte.springwebapp.swapi.openfeign;

import dev.leoduarte.springwebapp.swapi.dto.Specie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "species", url = "https://swapi.dev/api/species", primary = false)
public interface SwapiSpeciesClient {

    @GetMapping
    List<Specie> getSpecies();

    @GetMapping("/{id}")
    Specie getSpecie(@PathVariable("id") Long id);

}
