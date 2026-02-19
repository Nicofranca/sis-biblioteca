package com.weg.sis_biblioteca.dao;

import com.weg.sis_biblioteca.model.Livro;
import com.weg.sis_biblioteca.model.Usuario;
import com.weg.sis_biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDAO {
    public Usuario saveUsuario(Usuario usuario) throws SQLException {
        String query = """
                INSERT INTO usuario (nome, email) VALUES (?, ?)
                """;


        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()){
                    usuario.setId(rs.getInt(1));

                    return usuario;
                }
            }
        }
        throw new RuntimeException("Erro ao salvar Usuario");
    }

    public List<Usuario> findAll() throws SQLException {
        String query = """
                SELECT 
                id
                , nome
                , email 
                FROM 
                usuario
                """;

        List<Usuario> listUsuarios = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");

                    Usuario usuario = new Usuario(id, nome, email);
                    listUsuarios.add(usuario);

                }
                return listUsuarios;
            }
        }

    }

    public Usuario findById(int id) throws SQLException {
        String query = """
                SELECT 
                id
                , nome
                , email 
                FROM 
                usuario 
                WHERE
                id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");

                    Usuario usuario = new Usuario(id, nome, email);

                    return usuario;
                }
            }
        }

        throw new RuntimeException("Erro ao buscar livro por ID");

    }

    public void update(Usuario usuario) throws SQLException{
        String query = """
                UPDATE 
                usuario 
                SET 
                  nome = ?
                , email = ?
                 WHERE 
                 id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            stmt.setInt(3, usuario.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException{
        String query = """
                DELETE 
                FROM 
                usuario 
                WHERE 
                id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }
}

/*
CREATE TABLE usuario (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL
);
 */