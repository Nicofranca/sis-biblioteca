package com.weg.sis_biblioteca.controller;

import com.weg.sis_biblioteca.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PostMapping
    public Livro save(@RequestBody Livro livro){
        return null;
    }

    @GetMapping
    public List<Livro> findAll(){
        return List.of();
    }

    @GetMapping("/{id}")
    public Livro findById(@RequestBody Livro livro){
        return null;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id){

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){

    }
}
