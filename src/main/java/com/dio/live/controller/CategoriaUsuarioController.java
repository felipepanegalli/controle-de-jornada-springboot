package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoria-usuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @GetMapping
    public List<CategoriaUsuario> findAll() {
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(categoriaUsuarioService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Categoria de Usuário não encontrada")));
    }

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.save(categoriaUsuario);
    }

    @PutMapping
    public CategoriaUsuario update(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.update(categoriaUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            categoriaUsuarioService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
