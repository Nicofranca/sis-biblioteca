package com.weg.sis_biblioteca.controller;

import com.weg.sis_biblioteca.model.Usuario;
import com.weg.sis_biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{usuarios}")
public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return service.save(usuario);
    }

    @GetMapping
    public List<Usuario> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Usuario usuario){
        service.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
