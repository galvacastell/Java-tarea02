package com.tareas02Alva.tarea2_1.Services;

import com.tareas02Alva.tarea2_1.entities.usuario;

public interface usuarioService
{
    usuario createUsuario(usuario Usuario);
    usuario readByBane(Long Id);
    usuario update(usuario Usuario, Long Id);
    void delete(Long Id);
}
