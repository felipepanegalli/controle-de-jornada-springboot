package com.dio.live.service;

import com.dio.live.model.Localidade;
import com.dio.live.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    LocalidadeRepository localidadeRepository;

    @Autowired
    public LocalidadeService(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    // CREATE
    public Localidade save(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    // LIST ALL
    public List<Localidade> findAll() {
        return localidadeRepository.findAll();
    }

    // FIND BY ID
    public Optional<Localidade> findById(long id) {
        return localidadeRepository.findById(id);
    }

    // UPDATE
    public Localidade update(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    // DELETE
    public void deleteById(long id) {
        localidadeRepository.deleteById(id);
    }
}
