package com.weg.sis_biblioteca.controller.dto.livro;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LivroRequestDto(

        @NotBlank
        String titulo,

        @NotBlank
        String autor,

        @NotNull
        @Size(min = 1000, max = 2026)
        int anoPublicacao
) {
}
