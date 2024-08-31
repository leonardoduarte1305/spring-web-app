package dev.leoduarte.springwebapp.swapi.openfeign;

import dev.leoduarte.springwebapp.swapi.dto.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "vehicles", url = "https://swapi.dev/api/vehicles", primary = false)
public interface SwapiVehiclesClient {

    @GetMapping
    List<Vehicle> getVehicles();

    @GetMapping("/{id}")
    Vehicle getVehicle(@PathVariable("id") Long id);

}
