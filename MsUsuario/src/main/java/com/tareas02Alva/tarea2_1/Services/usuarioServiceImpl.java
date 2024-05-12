package com.tareas02Alva.tarea2_1.Services;

import com.tareas02Alva.tarea2_1.entities.category;
import com.tareas02Alva.tarea2_1.entities.usuario;
import com.tareas02Alva.tarea2_1.repositories.usuriousRepository;
import com.tareas02Alva.tarea2_1.repositories.documentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Transactional
@Slf4j
@AllArgsConstructor

public class usuarioServiceImpl implements usuarioService
{
    private final usuriousRepository UsuarioRepository;
    //private final documentRepository DocumentoRepository;

    @Override
    public usuario createUsuario(usuario usuario) {
        /*usuario.getDocumentos().forEach(obj -> {
            if(Objects.isNull(obj.getTipo())){
                obj.setTipo(1);
            }
        });*/
        return this.UsuarioRepository.save(usuario);
    }


    @Override
    public usuario readByBane(Long Id) {
        return this.UsuarioRepository.findById(Id)
        .orElseThrow(() -> new NoSuchElementException("Usuario no existe"));
    }

    @Override
    public usuario update(usuario Usuario, Long Id) {
        var documentosAct = this.UsuarioRepository.findById(Id)
                .orElseThrow(()->new NoSuchElementException("Documento no existe"));

        return this.UsuarioRepository.save(Usuario);
    }

    @Override
    public void delete(Long Id) {
        var usuarioToDelete = this.UsuarioRepository.findById(Id)
                .orElseThrow(()->new NoSuchElementException("Usuario no existe"));

        this.UsuarioRepository.delete(usuarioToDelete);

    }
}
