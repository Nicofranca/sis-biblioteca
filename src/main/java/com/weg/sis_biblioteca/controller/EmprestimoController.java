package com.weg.sis_biblioteca.controller;

import com.weg.sis_biblioteca.model.Emprestimo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @PostMapping
    public Emprestimo save(@RequestBody Emprestimo emprestimo){
        return  null;
    }

    @GetMapping
    public List<Emprestimo> findAll(){
        return List.of();
    }

    @GetMapping("/{id}")
    public Emprestimo findById(@PathVariable int id){
        return  null
                ;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id){

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){

    }

    @PutMapping("/{id}/devolucao")
    public void updateDevolucao(@PathVariable int id){

    }
}
