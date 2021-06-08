package com.dio.live.service;

import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

    NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    public NivelAcessoService(NivelAcessoRepository nivelAcessoRepository) {
        this.nivelAcessoRepository = nivelAcessoRepository;
    }

    // CREATE
    public NivelAcesso save(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    // LIST ALL
    public List<NivelAcesso> findAll() {
        return nivelAcessoRepository.findAll();
    }

    // FIND BY ID
    public Optional<NivelAcesso> findById(long id) {
        return nivelAcessoRepository.findById(id);
    }

    // UPDATE
    public NivelAcesso update(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    // DELETE
    public void deleteById(long id) {
        nivelAcessoRepository.deleteById(id);
    }
}
