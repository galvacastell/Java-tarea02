package com.tareas02Alva.tarea2_1.repositories;
import com.tareas02Alva.tarea2_1.entities.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usuriousRepository extends JpaRepository<usuario,Long>
{
    Optional<usuario> findById(Long aLong);
}
