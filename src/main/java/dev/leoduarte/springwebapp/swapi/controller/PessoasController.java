package dev.leoduarte.springwebapp.swapi.controller;

import dev.leoduarte.springwebapp.swapi.dto.Person;
import dev.leoduarte.springwebapp.swapi.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PessoasController {

    private final PeopleService service;

    @GetMapping("/pessoas/listar")
    public List<Person> getAllPeople() {
        return service.getPeople();
    }

    @GetMapping("/pessoas/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return service.getPeople(id);
    }

}
