package com.weg.sis_biblioteca.controller.dto.emprestimo;

import java.time.LocalDate;

public record EmprestimoResponseDto(
        int id,
        int livroId,
        int usuarioID,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao
) {
}
