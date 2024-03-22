package dev.aziz.vehiclesfinder.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleSummaryDto {

    private Long id;
    private String brand;
    private String model;
    private Integer production_year;
    private BigDecimal price;

}
