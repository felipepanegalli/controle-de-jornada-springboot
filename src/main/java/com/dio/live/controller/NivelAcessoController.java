package com.dio.live.controller;

import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivel-de-acesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService nivelAcessoService;

    @GetMapping
    public List<NivelAcesso> findAll() {
        return nivelAcessoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelAcesso> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(nivelAcessoService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nível de acesso não encontrado")));
    }

    @PostMapping
    public NivelAcesso create(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.save(nivelAcesso);
    }

    @PutMapping
    public NivelAcesso update(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.update(nivelAcesso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NivelAcesso> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            nivelAcessoService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
