package dev.leoduarte.springwebapp.swapi.service;

import dev.leoduarte.springwebapp.swapi.dto.Film;
import dev.leoduarte.springwebapp.swapi.openfeign.SwapiFilmsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmsService {

    private final SwapiFilmsClient client;

    public List<Film> getFilms() {
        return client.getFilms();
    }

    public Film getFilm(Long id) {
        return client.getFilm(id);
    }

}
