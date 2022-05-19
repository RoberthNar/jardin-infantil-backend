package com.ceiba.matricula_estudiante.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.estudiante.controlador.ComandoControladorEstudiante;
import com.ceiba.matricula_estudiante.comando.ComandoMatriculaEstudiante;
import com.ceiba.matricula_estudiante.servicio.ComandoMatriculaEstudianteTestDataBuilder;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorEstudiante.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorMatriculaEstudianteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una matricula estudiante")
    void deberiaCrearUnaMatriculaEstudiante() throws Exception {

        ComandoMatriculaEstudiante matriculaEstudiante = new ComandoMatriculaEstudianteTestDataBuilder().build();

        mocMvc.perform(post("/matricula-estudiantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(matriculaEstudiante)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar los datos de una matricula")
    void deberiaActualizarUnaMatriculaEstudiante() throws Exception {

        Long id = 1L;
        ComandoMatriculaEstudiante comandoMatriculaEstudiante = new ComandoMatriculaEstudianteTestDataBuilder().build();

        mocMvc.perform(put("/matricula-estudiantes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoMatriculaEstudiante)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar una matricula de un estudiante")
    void deberiaEliminarUnaMatriculaEstudiante() throws Exception {

        Long id = 2L;
        mocMvc.perform(delete("/matricula-estudiantes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}