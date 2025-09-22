package com.yp.DriveApi.models.clients;

import jakarta.validation.constraints.NotBlank;

public record ClientRequestDto(
         @NotBlank String name,
         @NotBlank String email,
         @NotBlank String cpf,
         @NotBlank String password
) {
}
