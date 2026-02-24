package com.weg.sis_biblioteca.controller.dto.livro;

public record LivroResponseDto(
        int id,
        String titulo,
        String autor,
        int anoPublicacao
) {
}
