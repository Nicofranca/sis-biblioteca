package com.weg.sis_biblioteca.controller.mapper;

import com.weg.sis_biblioteca.controller.dto.livro.LivroRequestDto;
import com.weg.sis_biblioteca.controller.dto.livro.LivroResponseDto;
import com.weg.sis_biblioteca.model.Livro;

public class LivroMapper {
    public Livro requestToEntity(LivroRequestDto livroRequestDto){
        return new Livro(
                livroRequestDto.titulo(),
                livroRequestDto.autor(),
                livroRequestDto.anoPublicacao());
    }

    public LivroResponseDto responseToEntity(Livro livro){
        return new LivroResponseDto(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAnoPublicacao()
        );
    }
}
