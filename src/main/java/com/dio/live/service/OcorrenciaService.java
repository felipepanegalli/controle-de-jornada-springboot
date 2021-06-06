package com.dio.live.service;

import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    // CREATE
    public Ocorrencia save(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    // LIST ALL
    public List<Ocorrencia> findAll() {
        return ocorrenciaRepository.findAll();
    }

    // FIND BY ID
    public Optional<Ocorrencia> findById(long id) {
        return ocorrenciaRepository.findById(id);
    }

    // UPDATE
    public Ocorrencia update(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    // DELETE
    public void deleteById(long id) {
        ocorrenciaRepository.deleteById(id);
    }
}
