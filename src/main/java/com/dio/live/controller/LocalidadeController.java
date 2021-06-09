package com.dio.live.controller;

import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @GetMapping
    public List<Localidade> findAll() {
        return localidadeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localidade> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(localidadeService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Localidade não encontrada")));
    }

    @PostMapping
    public Localidade create(@RequestBody Localidade localidade) {
        return localidadeService.save(localidade);
    }

    @PutMapping
    public Localidade update(@RequestBody Localidade localidade) {
        return localidadeService.update(localidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Localidade> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            localidadeService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
