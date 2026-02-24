package com.weg.sis_biblioteca.controller;

import com.weg.sis_biblioteca.controller.dto.usuario.UsuarioRequestDto;
import com.weg.sis_biblioteca.controller.dto.usuario.UsuarioResponseDto;
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
    public UsuarioResponseDto save(@RequestBody UsuarioRequestDto usuarioRequestDto){
        return service.save(usuarioRequestDto);
    }

    @GetMapping
    public List<UsuarioResponseDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto findById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UsuarioRequestDto usuarioRequestDto){
        service.update(id, usuarioRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
