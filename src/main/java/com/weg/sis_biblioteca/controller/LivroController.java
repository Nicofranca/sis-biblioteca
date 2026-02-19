package com.weg.sis_biblioteca.controller;

import com.weg.sis_biblioteca.model.Livro;
import com.weg.sis_biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }


    @PostMapping
    public Livro save(@RequestBody Livro livro){
        return livroService.save(livro);
    }

    @GetMapping
    public List<Livro> findAll(){
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public Livro findById(@PathVariable int id){
        return livroService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Livro livro){
        livroService.update(id, livro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        livroService.delete(id);
    }
}
