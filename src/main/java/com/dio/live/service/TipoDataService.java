package com.dio.live.service;

import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {

    TipoDataRepository tipoDataRepository;

    @Autowired
    public TipoDataService(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    // CREATE
    public TipoData save(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    // LIST ALL
    public List<TipoData> findAll() {
        return tipoDataRepository.findAll();
    }

    // FIND BY ID
    public Optional<TipoData> findById(long id) {
        return tipoDataRepository.findById(id);
    }

    // UPDATE
    public TipoData update(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    // DELETE
    public void deleteById(long id) {
        tipoDataRepository.deleteById(id);
    }
}
