package com.weg.sis_biblioteca.service;

import com.weg.sis_biblioteca.dao.UsuarioDAO;
import com.weg.sis_biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO){
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario save(Usuario usuario){
        try {
            return usuarioDAO.saveUsuario(usuario);
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

    public Usuario findById(int id){
        try {
            return usuarioDAO.findById(id);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Usuario usuario){
        try {
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
