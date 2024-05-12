package com.tareas02Alva.tarea2_1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class usuario {
    @Id
    private Long id_usu;

    @OneToMany(fetch = FetchType.LAZY,cascade ={CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    private List<cuenta> cuentas;
}

