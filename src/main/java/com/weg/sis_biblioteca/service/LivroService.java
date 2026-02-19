package com.weg.sis_biblioteca.service;

import com.weg.sis_biblioteca.dao.LivroDAO;
import com.weg.sis_biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private LivroDAO livroDAO;

    public LivroService(LivroDAO livroDAO){
        this.livroDAO = livroDAO;
    }

    public Livro save(Livro livro){
        try {
            return livroDAO.saveLivro(livro);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> findAll(){
        try {
            return livroDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro findById(int id){
        try {
            return livroDAO.findById(id);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Livro livro){
        try {

            livro.setId(id);
            livroDAO.update(livro);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            livroDAO.delete(id);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
