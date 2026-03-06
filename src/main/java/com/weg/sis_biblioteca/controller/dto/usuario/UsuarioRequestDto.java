package com.weg.sis_biblioteca.controller.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDto(

        @NotBlank
        String nome,

        @NotNull
        @Email
        String email
) {
}
