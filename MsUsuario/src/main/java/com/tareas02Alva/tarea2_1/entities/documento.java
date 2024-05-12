package com.tareas02Alva.tarea2_1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Column(columnDefinition = "tipo")
   // @Enumerated(value=EnumType.STRING)
    private Integer tipo;
    private String numero ;
}
