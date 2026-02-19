package com.weg.sis_biblioteca.service;

import com.weg.sis_biblioteca.dao.EmprestimoDAO;
import com.weg.sis_biblioteca.model.Emprestimo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EmprestimoService {
    private EmprestimoDAO dao;

    public EmprestimoService(EmprestimoDAO dao){
        this.dao = dao;
    }

    public Emprestimo save(Emprestimo emprestimo){
        try {
            emprestimo.setDataEmprestimo(LocalDate.now());

            return dao.save(emprestimo);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Emprestimo> findAll(){
        try {
            return dao.findAll();
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Emprestimo findById(int id){
        try {
            return dao.findById(id);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Emprestimo emprestimo){
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
