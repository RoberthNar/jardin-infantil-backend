package com.ceiba.estudiante.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.estudiante.comando.ComandoEstudiante;
import com.ceiba.estudiante.servicio.ComandoEstudianteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorEstudiante.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorEstudianteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un estudiante")
    void deberiaCrearUnEstudiante() throws Exception {

        ComandoEstudiante estudiante = new ComandoEstudianteTestDataBuilder().build();

        mocMvc.perform(post("/estudiantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudiante)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    @DisplayName("Deberia actualizar los datos de un estudiante")
    void deberiaActualizarUnEstudiante() throws Exception {

        Long id = 1L;
        ComandoEstudiante estudiante = new ComandoEstudianteTestDataBuilder().build();

        mocMvc.perform(put("/estudiantes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudiante)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un estudiante")
    void deberiaEliminarUnEstudiante() throws Exception {

        Long id = 2L;
        mocMvc.perform(delete("/estudiantes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}