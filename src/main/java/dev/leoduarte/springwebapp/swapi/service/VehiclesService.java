package dev.leoduarte.springwebapp.swapi.service;

import dev.leoduarte.springwebapp.swapi.dto.Vehicle;
import dev.leoduarte.springwebapp.swapi.openfeign.SwapiVehiclesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiclesService {

    private final SwapiVehiclesClient client;

    public List<Vehicle> getVehicles() {
        return client.getVehicles();
    }

    public Vehicle getVehicle(Long id) {
        return client.getVehicle(id);
    }

}
