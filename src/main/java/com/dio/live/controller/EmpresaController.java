package com.dio.live.controller;

import com.dio.live.model.Empresa;
import com.dio.live.model.Ocorrencia;
import com.dio.live.service.EmpresaService;
import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping
    public List<Empresa> findAll() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(empresaService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ocorrência não encontrada")));
    }

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @PutMapping
    public Empresa update(@RequestBody Empresa empresa) {
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            empresaService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
