package com.weg.sis_biblioteca.service;

import com.weg.sis_biblioteca.controller.dto.livro.LivroRequestDto;
import com.weg.sis_biblioteca.controller.dto.livro.LivroResponseDto;
import com.weg.sis_biblioteca.dao.LivroDAO;
import com.weg.sis_biblioteca.mapper.LivroMapper;
import com.weg.sis_biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private LivroDAO livroDAO;
    private LivroMapper livroMapper;

    public LivroService(LivroDAO livroDAO, LivroMapper livroMapper){
        this.livroDAO = livroDAO;
        this.livroMapper = livroMapper;
    }

    public LivroResponseDto save(LivroRequestDto livroRequestDto){
        try {

            Livro livro = livroMapper.requestToEntity(livroRequestDto);

            livroDAO.saveLivro(livro);

            LivroResponseDto livroResponseDto = livroMapper.responseToEntity(livro);

            return livroResponseDto;
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

    public LivroResponseDto findById(int id){
        try {
            Livro livro = livroDAO.findById(id);

            LivroResponseDto livroResponseDto = livroMapper.responseToEntity(livro);

            return livroResponseDto;
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, LivroRequestDto livroRequestDto){
        try {

            Livro livro = livroMapper.requestToEntity(livroRequestDto);

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
