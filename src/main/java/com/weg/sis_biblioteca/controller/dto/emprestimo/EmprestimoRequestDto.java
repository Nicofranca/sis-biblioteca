package com.weg.sis_biblioteca.controller.dto.emprestimo;

import java.time.LocalDate;

public record EmprestimoRequestDto(
        int livroId,
        int usuarioId,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao
) {
}
