package com.yp.DriveApi.models.clients;

import jakarta.validation.constraints.NotBlank;

public record ClientLoginDto(
        @NotBlank String email,
        @NotBlank String password
) {
}
