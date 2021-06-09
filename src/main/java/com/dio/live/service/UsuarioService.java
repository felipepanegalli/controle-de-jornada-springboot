package com.dio.live.service;

import com.dio.live.model.Usuario;
import com.dio.live.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // CREATE
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // LIST ALL
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // FIND BY ID
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    // UPDATE
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // DELETE
    public void deleteById(long id) {
        usuarioRepository.deleteById(id);
    }
}
