package dev.leoduarte.springwebapp.swapi.service;

import dev.leoduarte.springwebapp.swapi.dto.Person;
import dev.leoduarte.springwebapp.swapi.openfeign.SwapiPeopleClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final SwapiPeopleClient client;

    public List<Person> getPeople() {
        return client.getPeople();
    }

    public Person getPeople(Long id) {
        return client.getPerson(id);
    }

}
