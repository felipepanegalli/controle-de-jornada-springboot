package com.dio.live.service;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    // CREATE
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // LIST ALL
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    // FIND BY ID
    public Optional<Empresa> findById(long id) {
        return empresaRepository.findById(id);
    }

    // UPDATE
    public Empresa update(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // DELETE
    public void deleteById(long id) {
        empresaRepository.deleteById(id);
    }
}
