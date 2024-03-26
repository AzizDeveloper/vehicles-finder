package dev.aziz.vehiclesfinder.mappers;

import dev.aziz.vehiclesfinder.dtos.VehicleSummaryDto;
import dev.aziz.vehiclesfinder.entities.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleSummaryDto vehicleToVehicleSummaryDto(Vehicle vehicle);

    List<VehicleSummaryDto> vehiclestoVehicleSummaryDtos(List<Vehicle> vehicles);

}
