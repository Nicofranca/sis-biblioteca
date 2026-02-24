package com.weg.sis_biblioteca.controller.dto.livro;

public record LivroRequestDto(
        String titulo,
        String autor,
        int anoPublicacao
) {
}
