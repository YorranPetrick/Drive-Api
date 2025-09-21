package com.yp.DriveApi.models.rent;

import com.yp.DriveApi.models.clients.Client;
import com.yp.DriveApi.models.vehicle.Vehicle;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "vehicle_rentals")
public class VehicleRental {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idRental;
    @Column(nullable = false)
    private Instant dateRental;
    @Column(nullable = false)
    private Instant dateReturn;

    @ManyToOne
    private Client clientRental;
    @ManyToOne
    private Vehicle vehicleRental;
}
