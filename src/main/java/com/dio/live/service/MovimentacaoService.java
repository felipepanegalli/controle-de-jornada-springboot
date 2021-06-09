package com.dio.live.service;

import com.dio.live.model.Movimentacao;
import com.dio.live.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    MovimentacaoRepository movimentacaoRepository;

    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    // CREATE
    public Movimentacao save(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    // LIST ALL
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    // FIND BY ID
    public Optional<Movimentacao> findById(long id) {
        return movimentacaoRepository.findById(id);
    }

    // UPDATE
    public Movimentacao update(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    // DELETE
    public void deleteById(long id) {
        movimentacaoRepository.deleteById(id);
    }
}
