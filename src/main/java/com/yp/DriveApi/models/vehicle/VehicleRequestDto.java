package com.yp.DriveApi.models.vehicle;

import jakarta.validation.constraints.NotBlank;

public record VehicleRequestDto(
        @NotBlank String modelVehicle,
        @NotBlank String plateNumber,
        String colorVehicle
) {
}
