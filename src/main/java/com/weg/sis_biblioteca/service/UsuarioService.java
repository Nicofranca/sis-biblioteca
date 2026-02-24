package com.weg.sis_biblioteca.service;

import com.weg.sis_biblioteca.controller.dto.usuario.UsuarioRequestDto;
import com.weg.sis_biblioteca.controller.dto.usuario.UsuarioResponseDto;
import com.weg.sis_biblioteca.dao.UsuarioDAO;
import com.weg.sis_biblioteca.mapper.UsuarioMapper;
import com.weg.sis_biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioDAO usuarioDAO;
    private UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioDAO usuarioDAO, UsuarioMapper usuarioMapper){
        this.usuarioDAO = usuarioDAO;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioResponseDto save(UsuarioRequestDto usuarioRequestDto){
        try {

            Usuario usuario = usuarioMapper.requestToEntity(usuarioRequestDto);

            usuarioDAO.saveUsuario(usuario);

            return usuarioMapper.responseToEntity(usuario);


        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> findAll(){
        try {
            return usuarioDAO.findAll();
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public UsuarioResponseDto findById(int id){
        try {

            Usuario usuario = usuarioDAO.findById(id);

            UsuarioResponseDto usuarioResponseDto = usuarioMapper.responseToEntity(usuario);

            return usuarioResponseDto;

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, UsuarioRequestDto usuarioRequestDto){
        try {

            Usuario usuario = usuarioMapper.requestToEntity(usuarioRequestDto);

            usuario.setId(id);

            usuarioDAO.update(usuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            usuarioDAO.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
