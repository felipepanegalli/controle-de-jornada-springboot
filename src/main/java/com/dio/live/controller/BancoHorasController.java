package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/banco-de-horas")
public class BancoHorasController {

    @Autowired
    BancoHorasService bancoHorasService;

    @GetMapping
    public List<BancoHoras> findAll() {
        return bancoHorasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoHoras> findById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(bancoHorasService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Banco de horas não encontrado")));
    }

    @PostMapping
    public BancoHoras create(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.save(bancoHoras);
    }

    @PutMapping
    public BancoHoras update(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.update(bancoHoras);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BancoHoras> deleteById(@PathVariable(value = "id") long id) throws Exception {
        try {
            bancoHorasService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
