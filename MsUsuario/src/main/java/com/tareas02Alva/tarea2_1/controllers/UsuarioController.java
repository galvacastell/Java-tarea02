package com.tareas02Alva.tarea2_1.controllers;

import com.tareas02Alva.tarea2_1.entities.usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping(path = "Usuario")
@Slf4j
@Tag(name ="Tarea 02 Micro Usuario")

public class UsuarioController {
    private final com.tareas02Alva.tarea2_1.Services.usuarioService usuarioService;

    @Operation(summary = "Get Devolver Usuario")
    @GetMapping(path = "{Id}")
    public ResponseEntity<usuario> get(@PathVariable Long Id)
    {
       log.info("GET: Usuario{}",Id);
       return ResponseEntity.ok(this.usuarioService.readByBane(Id));
    }

    @Operation(summary = "Post Crear Usuario")
    @PostMapping
    public ResponseEntity<usuario> post(@RequestBody usuario Usuario)
    {
        log.info("Post: Usuario {}", Usuario.getNombre());
        return ResponseEntity.created(URI.create(this.usuarioService.createUsuario(Usuario).getNombre())).build();
    }

    @Operation(summary = "PUT Actualza Usuario")
    @PutMapping(path="{Id}")
    public ResponseEntity<usuario> put(@RequestBody usuario usuario, @PathVariable Long Id)
    {
        log.info("PUT: Usuario {}",Id);
        return ResponseEntity.ok(this.usuarioService.update(usuario, Id));
    }

    @Operation(summary = "DELETE Elimina Usuario")
    @DeleteMapping(path="{Id}")
    public ResponseEntity<?> delete(@PathVariable Long Id)
    {
        log.info("DELETE: usuario {}",Id);
        return ResponseEntity.noContent().build();
    }

}













