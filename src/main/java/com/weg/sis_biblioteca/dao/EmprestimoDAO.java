package com.weg.sis_biblioteca.dao;

import com.weg.sis_biblioteca.model.Emprestimo;
import com.weg.sis_biblioteca.model.Livro;
import com.weg.sis_biblioteca.model.Usuario;
import com.weg.sis_biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmprestimoDAO {
    public Emprestimo save(Emprestimo emprestimo) throws SQLException {
        String query = """
                INSERT INTO emprestimo (livro_id, usuario_id, data_emprestimo) VALUES (?, ?, ?)
                """;


        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, emprestimo.getLivroId());
            stmt.setInt(2, emprestimo.getUsuarioID());
            stmt.setObject(3, emprestimo.getDataEmprestimo());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()){
                    emprestimo.setId(rs.getInt(1));

                    return emprestimo;
                }
            }
        }
        throw new RuntimeException("Erro ao salvar Usuario");
    }

    public List<Emprestimo> findAll() throws SQLException {
        String query = """
                SELECT 
                    id
                , livro_id
                , usuario_id
                , data_emprestimo
                , data_devolucao
                FROM 
                emprestimo
                """;

        List<Emprestimo> listEmprestimo = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    int idLivro = rs.getInt("livro_id");
                    int idUsuario = rs.getInt("usuario_id");
                    LocalDate dataEmprestimo = rs.getDate("data_emprestimo").toLocalDate();
                    LocalDate dataDevolucao = rs.getObject("data_devolucao", LocalDate.class);

                    Emprestimo emprestimo = new Emprestimo(id, idLivro, idUsuario, dataEmprestimo, dataDevolucao);
                    listEmprestimo.add(emprestimo);

                }
                return listEmprestimo;
            }
        }

    }

    public Emprestimo findById(int id) throws SQLException {
        String query = """
                SELECT 
                  id
                , livro_id
                , usuario_id
                , data_emprestimo
                , data_devolucao
                FROM 
                emprestimo 
                WHERE
                id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    int idLivro = rs.getInt("livro_id");
                    int idUsuario = rs.getInt("usuario_id");
                    LocalDate dataEmprestimo = rs.getDate("data_emprestimo").toLocalDate();
                    LocalDate dataDevolucao = rs.getObject("data_devolucao", LocalDate.class);

                    Emprestimo emprestimo = new Emprestimo(id, idLivro, idUsuario, dataEmprestimo, dataDevolucao);

                    return emprestimo;
                }
            }
        }

        throw new RuntimeException("Erro ao buscar livro por ID");

    }

    public void update(Emprestimo emprestimo) throws SQLException{
        String query = """
                UPDATE 
                emprestimo 
                SET 
                  livro_id = ?
                , usuario_id = ?
                 WHERE 
                 id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, emprestimo.getLivroId());
            stmt.setInt(2, emprestimo.getUsuarioID());
            stmt.setInt(3, emprestimo.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException{
        String query = """
                DELETE 
                FROM 
                emprestimo 
                WHERE 
                id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

    public void updateDevolucao(LocalDate dataDevolucao, int id) throws SQLException{
        String query = """
                UPDATE 
                emprestimo 
                SET 
                 data_devolucao = ?
                 WHERE 
                 id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setObject(1, dataDevolucao);
            stmt.setInt(2, id);

            stmt.executeUpdate();
        }
    }
}


