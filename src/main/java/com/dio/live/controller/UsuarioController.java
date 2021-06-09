package com.dio.live.controller;

import com.dio.live.model.Usuario;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(usuarioService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado")));
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return usuarioService.update(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            usuarioService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
