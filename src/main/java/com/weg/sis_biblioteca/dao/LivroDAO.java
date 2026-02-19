package com.weg.sis_biblioteca.dao;

import com.weg.sis_biblioteca.model.Livro;
import com.weg.sis_biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroDAO {
    public Livro saveLivro(Livro livro) throws SQLException {
        String query = """
                INSERT INTO livro (titulo, autor, ano_publicacao) VALUES (?, ?, ?)
                """;


        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAnoPublicacao());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()){
                    livro.setId(rs.getInt(1));

                    return livro;
                }
            }
        }
        throw new RuntimeException("Livro nao salvo");
    }

    public List<Livro> findAll() throws SQLException {
        String query = """
                SELECT 
                id
                , titulo
                , autor
                , ano_publicacao 
                FROM 
                livro
                """;

        List<Livro> listLivros = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String autor = rs.getString("autor");
                    String titulo = rs.getString("titulo");
                    int anoPublicacao = rs.getInt("ano_publicacao");

                    Livro livro = new Livro(id, autor, titulo, anoPublicacao);
                    listLivros.add(livro);

                }
                return listLivros;
            }
        }

    }

    public Livro findById(int id) throws SQLException {
        String query = """
                SELECT 
                id
                , titulo
                , autor
                , ano_publicacao 
                FROM 
                livro 
                WHERE
                id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    String autor = rs.getString("autor");
                    String titulo = rs.getString("titulo");
                    int anoPublicacao = rs.getInt("ano_publicacao");

                    Livro livro = new Livro(id, autor, titulo, anoPublicacao);

                    return livro;
                }
            }
        }

        throw new RuntimeException("Erro ao buscar livro por ID");

    }

    public void update(Livro livro) throws SQLException{
        String query = """
                UPDATE 
                livro 
                SET 
                  titulo = ?
                , autor = ?
                , ano_publicacao = ?
                 WHERE 
                 id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAnoPublicacao());

            stmt.setInt(4, livro.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException{
        String query = """
                DELETE 
                FROM 
                livro 
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
/*CREATE TABLE livro (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(150) NOT NULL,
autor VARCHAR(100) NOT NULL,
ano_publicacao INT NOT NULL
);

 */