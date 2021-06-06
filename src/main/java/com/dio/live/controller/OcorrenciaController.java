package com.dio.live.controller;

import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @GetMapping
    public List<Ocorrencia> findAll() {
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(ocorrenciaService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ocorrência não encontrada")));
    }

    @PostMapping
    public Ocorrencia create(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.save(ocorrencia);
    }

    @PutMapping
    public Ocorrencia update(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.update(ocorrencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ocorrencia> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            ocorrenciaService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
