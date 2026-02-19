package com.weg.sis_biblioteca.controller;

import com.weg.sis_biblioteca.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{usuarios}")
public class UsuarioController {

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return null;
    }

    @GetMapping
    public List<Usuario> findAll(){
        return List.of();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable int id){
        return null;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id){

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){

    }
}
