package com.weg.sis_biblioteca.controller;

import com.weg.sis_biblioteca.model.Emprestimo;
import com.weg.sis_biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private EmprestimoService service;

    public EmprestimoController(EmprestimoService service){
        this.service = service;
    }

    @PostMapping
    public Emprestimo save(@RequestBody Emprestimo emprestimo){
        return  service.save(emprestimo);
    }

    @GetMapping
    public List<Emprestimo> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Emprestimo findById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Emprestimo emprestimo){
        service.update(id, emprestimo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @PatchMapping("/{id}/devolucao")
    public void updateDevolucao(@PathVariable int id){
        service.updateDevolucao(id);
    }
}
