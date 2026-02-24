package com.weg.sis_biblioteca.controller.mapper;

import com.weg.sis_biblioteca.controller.dto.usuario.UsuarioRequestDto;
import com.weg.sis_biblioteca.controller.dto.usuario.UsuarioResponseDto;
import com.weg.sis_biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario requestToEntity(UsuarioRequestDto usuarioRequestDto){
        return new Usuario(usuarioRequestDto.nome(), usuarioRequestDto.email());
    }

    public UsuarioResponseDto responseToEntity(Usuario usuario){
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}
