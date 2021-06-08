package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipo-data")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @GetMapping
    public List<TipoData> findAll() {
        return tipoDataService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoData> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(tipoDataService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tipo data não encontrado")));
    }

    @PostMapping
    public TipoData create(@RequestBody TipoData tipoData) {
        return tipoDataService.save(tipoData);
    }

    @PutMapping
    public TipoData update(@RequestBody TipoData tipoData) {
        return tipoDataService.update(tipoData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoData> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            tipoDataService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
