package com.yp.DriveApi.controller.vehicles;

import com.yp.DriveApi.models.vehicle.VehicleRequestDto;
import com.yp.DriveApi.service.vehicle.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    private VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    private ResponseEntity createVehicle(@RequestBody @Valid VehicleRequestDto vehicle) {
        vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok("Vehicle created");
    }
}
