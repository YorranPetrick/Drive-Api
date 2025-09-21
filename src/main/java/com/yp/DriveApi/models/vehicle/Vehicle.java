package com.yp.DriveApi.models.vehicle;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Getter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idVehicle;
    @Column(nullable = false)
    private String modelVehicle;
    @Column(nullable = false, unique = true)
    private String plateNumber;
    private String colorVehicle;

    public Vehicle(String modelVehicle, String plateNumber, String colorVehicle) {
        this.modelVehicle = modelVehicle;
        this.plateNumber = plateNumber;
        this.colorVehicle = colorVehicle;
    }
}
