package dev.leoduarte.springwebapp.swapi.openfeign;

import dev.leoduarte.springwebapp.swapi.dto.Film;
import dev.leoduarte.springwebapp.swapi.dto.Person;
import dev.leoduarte.springwebapp.swapi.dto.Planet;
import dev.leoduarte.springwebapp.swapi.dto.Specie;
import dev.leoduarte.springwebapp.swapi.dto.Starship;
import dev.leoduarte.springwebapp.swapi.dto.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "root", url = "https://swapi.dev/api", primary = false)
public interface SwapiRootClient {

    @GetMapping("/films")
    List<Film> getFilms();

    @GetMapping("/people")
    List<Person> getPeople();

    @GetMapping("/planets")
    List<Planet> getPlanets();

    @GetMapping("/species")
    List<Specie> getSpecies();

    @GetMapping("/startships")
    List<Starship> getStarships();

    @GetMapping("/vehicles")
    List<Vehicle> getVehicles();

}
