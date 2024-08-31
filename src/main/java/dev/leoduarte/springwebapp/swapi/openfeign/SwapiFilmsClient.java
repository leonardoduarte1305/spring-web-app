package dev.leoduarte.springwebapp.swapi.openfeign;

import dev.leoduarte.springwebapp.swapi.dto.Film;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "films", url = "https://swapi.dev/api/films", primary = false)
public interface SwapiFilmsClient {

    @GetMapping
    List<Film> getFilms();

    @GetMapping("/{id}")
    Film getFilm(@PathVariable Long id);

}
