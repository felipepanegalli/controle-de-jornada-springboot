package com.dio.live.service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaUsuarioService {

    CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository) {
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }

    // CREATE
    public CategoriaUsuario save(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    // LIST ALL
    public List<CategoriaUsuario> findAll() {
        return categoriaUsuarioRepository.findAll();
    }

    // FIND BY ID
    public Optional<CategoriaUsuario> findById(long id) {
        return categoriaUsuarioRepository.findById(id);
    }

    // UPDATE
    public CategoriaUsuario update(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    // DELETE
    public void deleteById(long id) {
        categoriaUsuarioRepository.deleteById(id);
    }
}
