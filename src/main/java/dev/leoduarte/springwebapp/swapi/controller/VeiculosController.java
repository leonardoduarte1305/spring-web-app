package dev.leoduarte.springwebapp.swapi.controller;

import dev.leoduarte.springwebapp.swapi.dto.Vehicle;
import dev.leoduarte.springwebapp.swapi.service.VehiclesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VeiculosController {

    private final VehiclesService service;

    @GetMapping("/veiculos/listar")
    public List<Vehicle> getAllVehicles() {
        return service.getVehicles();
    }

    @GetMapping("/veiculos/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return service.getVehicle(id);
    }

}
