package com.weg.sis_biblioteca.service;

import com.weg.sis_biblioteca.controller.dto.emprestimo.EmprestimoRequestDto;
import com.weg.sis_biblioteca.controller.dto.emprestimo.EmprestimoResponseDto;
import com.weg.sis_biblioteca.dao.EmprestimoDAO;
import com.weg.sis_biblioteca.mapper.EmprestimoMapper;
import com.weg.sis_biblioteca.model.Emprestimo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EmprestimoService {
    private EmprestimoDAO dao;
    private EmprestimoMapper emprestimoMapper;

    public EmprestimoService(EmprestimoDAO dao, EmprestimoMapper emprestimoMapper){
        this.dao = dao;
        this.emprestimoMapper = emprestimoMapper;
    }

    public EmprestimoResponseDto save(EmprestimoRequestDto emprestimoRequestDto){
        try {

            Emprestimo emprestimo = emprestimoMapper.requestToEntity(emprestimoRequestDto);

            emprestimo.setDataEmprestimo(LocalDate.now());

            dao.save(emprestimo);

            EmprestimoResponseDto emprestimoResponseDto = emprestimoMapper.responseToEntity(emprestimo);

            return emprestimoResponseDto;
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EmprestimoResponseDto> findAll(){
        try {
            return dao.findAll().stream()
                    .map(emprestimoMapper::responseToEntity)
                    .toList();

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public EmprestimoResponseDto findById(int id){
        try {

            Emprestimo emprestimo = dao.findById(id);

            EmprestimoResponseDto emprestimoResponseDto = emprestimoMapper.responseToEntity(emprestimo);

            return emprestimoResponseDto;
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, EmprestimoRequestDto emprestimoRequestDto){

        Emprestimo emprestimo = emprestimoMapper.requestToEntity(emprestimoRequestDto);
        emprestimo.setId(id);

        try {
            dao.update(emprestimo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            dao.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDevolucao(int id){
        try {
            LocalDate date = LocalDate.now();

            dao.updateDevolucao(date, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
