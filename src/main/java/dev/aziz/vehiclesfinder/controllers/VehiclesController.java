package dev.aziz.vehiclesfinder.controllers;

import dev.aziz.vehiclesfinder.dtos.VehicleSummaryDto;
import dev.aziz.vehiclesfinder.entities.Vehicle;
import dev.aziz.vehiclesfinder.services.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles")
public class VehiclesController {

    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleSummaryDto>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getVehicleSummaries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getOneVehicle(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getOneItem(id));
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody @Valid Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.createVehicle(vehicle);
        return ResponseEntity.created(URI.create("/" + savedVehicle.getId()))
                .body(savedVehicle);
    }

}
