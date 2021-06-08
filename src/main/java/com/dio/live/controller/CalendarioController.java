package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @GetMapping
    public List<Calendario> findAll() {
        return calendarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendario> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(calendarioService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Calendário não encontrado")));
    }

    @PostMapping
    public Calendario create(@RequestBody Calendario calendario) {
        return calendarioService.save(calendario);
    }

    @PutMapping
    public Calendario update(@RequestBody Calendario calendario) {
        return calendarioService.update(calendario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Calendario> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            calendarioService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
