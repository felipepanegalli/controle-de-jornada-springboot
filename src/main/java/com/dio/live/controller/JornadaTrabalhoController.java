package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaTrabalhoService jornadaTrabalhoService;

    @GetMapping
    public List<JornadaTrabalho> findAll() {
        return jornadaTrabalhoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(jornadaTrabalhoService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Jornada não encontrada")));
    }

    @PostMapping
    public JornadaTrabalho create(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoService.save(jornadaTrabalho);
    }

    @PutMapping
    public JornadaTrabalho update(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            jornadaTrabalhoService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
