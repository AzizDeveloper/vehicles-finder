package dev.aziz.vehiclesfinder.services;

import dev.aziz.vehiclesfinder.dtos.VehicleSummaryDto;
import dev.aziz.vehiclesfinder.entities.Vehicle;
import dev.aziz.vehiclesfinder.exceptions.AppException;
import dev.aziz.vehiclesfinder.mappers.VehicleMapper;
import dev.aziz.vehiclesfinder.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public List<VehicleSummaryDto> getVehicleSummaries() {
        return vehicleMapper.vehiclestoVehicleSummaryDtos(vehicleRepository.findAll());
    }

    public Vehicle getOneItem(Long id) {
        return vehicleRepository.findVehicleById(id)
                .orElseThrow(() -> new AppException("Vehicle not found.", HttpStatus.NOT_FOUND));
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);

    }
}
