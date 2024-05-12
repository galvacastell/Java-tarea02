package com.tareas02Alva.tarea2_1.Services;

import com.tareas02Alva.tarea2_1.entities.usuario;
import com.tareas02Alva.tarea2_1.repositories.usuriousRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Transactional
@Slf4j
@AllArgsConstructor

public class usuarioServiceImpl implements usuarioService
{
    private final usuriousRepository UsuarioRepository;

    @Override
    public usuario createUsuario(usuario usuario) {
        return this.UsuarioRepository.save(usuario);
    }

    @Override
    public usuario readByBane(Long Id) {
        return this.UsuarioRepository.findById(Id)
        .orElseThrow(() -> new NoSuchElementException("Usuario y cuentas no existe"));
    }

    @Override
    public usuario update(usuario Usuario, Long Id) {
        var documentosAct = this.UsuarioRepository.findById(Id)
                .orElseThrow(()->new NoSuchElementException("Cuenta no existe"));

        return this.UsuarioRepository.save(Usuario);
    }

    @Override
    public void delete(Long Id) {
        var usuarioToDelete = this.UsuarioRepository.findById(Id)
                .orElseThrow(()->new NoSuchElementException("Cuenta no existe"));

        this.UsuarioRepository.delete(usuarioToDelete);

    }
}
