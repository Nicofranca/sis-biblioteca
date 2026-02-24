package com.weg.sis_biblioteca.controller;

import com.weg.sis_biblioteca.controller.dto.livro.LivroRequestDto;
import com.weg.sis_biblioteca.controller.dto.livro.LivroResponseDto;
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
    public LivroResponseDto save(@RequestBody LivroRequestDto livroRequestDto){
        return livroService.save(livroRequestDto);
    }

    @GetMapping
    public List<LivroResponseDto> findAll(){
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public LivroResponseDto findById(@PathVariable int id){
        return livroService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody LivroRequestDto livroRequestDto){
        livroService.update(id, livroRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        livroService.delete(id);
    }
}
