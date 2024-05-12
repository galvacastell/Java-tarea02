package com.tareas02Alva.tarea2_1.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Gian Alva",
                version = "1.0.0",
                description = "Este codigo es de la segunda tarea micro 1"
        )
)


public class OpenApiConfig {
}
