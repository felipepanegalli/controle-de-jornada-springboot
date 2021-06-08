package com.dio.live.service;

import com.dio.live.model.Calendario;
import com.dio.live.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {

    CalendarioRepository calendarioRepository;

    @Autowired
    public CalendarioService(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    // CREATE
    public Calendario save(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    // LIST ALL
    public List<Calendario> findAll() {
        return calendarioRepository.findAll();
    }

    // FIND BY ID
    public Optional<Calendario> findById(long id) {
        return calendarioRepository.findById(id);
    }

    // UPDATE
    public Calendario update(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    // DELETE
    public void deleteById(long id) {
        calendarioRepository.deleteById(id);
    }
}
