package com.weg.sis_biblioteca.controller.dto.emprestimo;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record EmprestimoRequestDto(

        @NotNull
        @Positive
        int livroId,

        @NotNull
        @Positive
        int usuarioId,

        @NotNull
        @PastOrPresent
        LocalDate dataEmprestimo,

        @NotNull
        @FutureOrPresent
        LocalDate dataDevolucao
) {
}
