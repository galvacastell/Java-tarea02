package com.tareas02Alva.tarea2_1.Services;
import com.tareas02Alva.tarea2_1.Domain.listarUsuarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tareas02Alva.tarea2_1.Services.usuarioService;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


public class StringUtilitiesServiceTest {
    @InjectMocks
    usuarioService UsuarioService;
    //StringUtilitiesServiceTest springUtilities;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenStringNotNull_thenReturnUppercase(){

    /*    long id=1;
        String result = UsuarioService.readByBane(id).toString();

        assert result.equals(expected);*/
    }
}
