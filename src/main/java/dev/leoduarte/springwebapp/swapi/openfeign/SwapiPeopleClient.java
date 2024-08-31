package dev.leoduarte.springwebapp.swapi.openfeign;

import dev.leoduarte.springwebapp.swapi.dto.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "people", url = "https://swapi.dev/api/people", primary = false)
public interface SwapiPeopleClient {

    @GetMapping
    List<Person> getPeople();

    @GetMapping("/{id}")
    Person getPerson(@PathVariable("id") Long id);

}
