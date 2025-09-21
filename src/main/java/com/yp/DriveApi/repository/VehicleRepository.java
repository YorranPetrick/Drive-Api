package com.yp.DriveApi.repository;

import com.yp.DriveApi.models.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
}
