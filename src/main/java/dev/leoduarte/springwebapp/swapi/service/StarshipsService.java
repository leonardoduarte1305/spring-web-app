package dev.leoduarte.springwebapp.swapi.service;

import dev.leoduarte.springwebapp.swapi.dto.Starship;
import dev.leoduarte.springwebapp.swapi.openfeign.SwapiStarshipsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StarshipsService {

    private final SwapiStarshipsClient client;

    public List<Starship> getStarships() {
        return client.getStarships();
    }

    public Starship getStarship(Long id) {
        return client.getStarship(id);
    }

}
