package dev.leoduarte.springwebapp.swapi.openfeign;

import dev.leoduarte.springwebapp.swapi.dto.Starship;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "starships", url = "https://swapi.dev/api/starships", primary = false)
public interface SwapiStarshipsClient {

    @GetMapping
    List<Starship> getStarships();

    @GetMapping("/{id}")
    Starship getStarship(@PathVariable("id") Long id);

}
