package dev.leoduarte.springwebapp.swapi.controller;

import dev.leoduarte.springwebapp.swapi.dto.Film;
import dev.leoduarte.springwebapp.swapi.service.FilmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmesController {

    private final FilmsService service;

    @GetMapping("/filmes/listar")
    public List<Film> getAllFilms() {
        return service.getFilms();
    }

    @GetMapping("/filmes/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return service.getFilm(id);
    }

}
