package dev.aziz.vehiclesfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiclesFinderApplication {
    //TODO: Create sql files (data.sql file etc.) and run Docker container for it.
    public static void main(String[] args) {
        SpringApplication.run(VehiclesFinderApplication.class, args);
    }

}
