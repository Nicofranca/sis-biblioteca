package com.weg.sis_biblioteca.controller.mapper;

import com.weg.sis_biblioteca.controller.dto.emprestimo.EmprestimoRequestDto;
import com.weg.sis_biblioteca.controller.dto.emprestimo.EmprestimoResponseDto;
import com.weg.sis_biblioteca.model.Emprestimo;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {
    public Emprestimo requestToEntity(EmprestimoRequestDto emprestimoRequestDto){
        return new Emprestimo(
                emprestimoRequestDto.livroId(),
                emprestimoRequestDto.usuarioId(),
                emprestimoRequestDto.dataEmprestimo(),
                emprestimoRequestDto.dataDevolucao()
        );
    }

    public EmprestimoResponseDto responseToEntity(Emprestimo emprestimo){
        return new EmprestimoResponseDto(
                emprestimo.getId(),
                emprestimo.getLivroId(),
                emprestimo.getUsuarioID(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao()
        );
    }
}
