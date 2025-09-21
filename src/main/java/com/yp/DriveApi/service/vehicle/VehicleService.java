package com.yp.DriveApi.service.vehicle;

import com.yp.DriveApi.models.exceptions.ResponseExceptions;
import com.yp.DriveApi.models.vehicle.Vehicle;
import com.yp.DriveApi.models.vehicle.VehicleRequestDto;
import com.yp.DriveApi.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public ResponseExceptions createVehicle(VehicleRequestDto vehicle) {
        try {
            Vehicle vehicleCreate = new Vehicle(vehicle.modelVehicle(),
                    vehicle.plateNumber(),
                    vehicle.colorVehicle());

            vehicleRepository.save(vehicleCreate);

            return new ResponseExceptions("Vehicle created successfully", true);
        } catch (Exception e) {
            return new ResponseExceptions("Failed to create vehicle: " + e, false);
        }
    }
}
