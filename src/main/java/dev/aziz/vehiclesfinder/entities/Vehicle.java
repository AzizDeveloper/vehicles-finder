package dev.aziz.vehiclesfinder.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Brand should not be empty")
    private String brand;

    @NotEmpty(message = "Model should not be empty")
    private String model;

    @NotNull(message = "Production year should not be empty")
    private Integer productionYear;

    @NotNull(message = "Kilometres should not be empty")
    private Double kilometres;

    @NotEmpty(message = "City should not be empty")
    private String city;

    @NotEmpty(message = "Pictures list should not be empty")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Picture> pictures;

    @NotNull(message = "Price should not be empty")
    @Column(precision = 10, scale = 3)
    private BigDecimal price;

    @CreatedDate
    @Column(name = "created_date")
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

}
