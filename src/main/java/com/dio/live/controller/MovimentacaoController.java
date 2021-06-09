package com.dio.live.controller;

import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Movimentacao> findAll() {
        return movimentacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(movimentacaoService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Movimentação não encontrada")));
    }

    @PostMapping
    public Movimentacao create(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.save(movimentacao);
    }

    @PutMapping
    public Movimentacao update(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.update(movimentacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movimentacao> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            movimentacaoService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
