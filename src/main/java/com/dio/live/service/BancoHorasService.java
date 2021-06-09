package com.dio.live.service;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    // CREATE
    public BancoHoras save(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    // LIST ALL
    public List<BancoHoras> findAll() {
        return bancoHorasRepository.findAll();
    }

    // FIND BY ID
    public Optional<BancoHoras> findById(long id) {
        return bancoHorasRepository.findById(id);
    }

    // UPDATE
    public BancoHoras update(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    // DELETE
    public void deleteById(long id) {
        bancoHorasRepository.deleteById(id);
    }
}
