package com.ceiba.matricula_estudiante.controlador;

import com.ceiba.ApplicationMock;
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

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorMatriculaEstudiante.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorMatriculaEstudianteTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar una matricula por id")
    void deberiaListarEstudiantesPorId() throws Exception {

        Long idMatriculaEstudiante = 1L;

        mocMvc.perform(get("/matricula-estudiantes/{id}", idMatriculaEstudiante)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)));

    }

    @Test
    @DisplayName("Deberia listar todos las matriculas de los estudiantes")
    void deberiaListarMatriculasEstudiantes() throws Exception {

        mocMvc.perform(get("/matricula-estudiantes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)));

    }

    @Test
    @DisplayName("Deberia listar todos los estudiantes sin matricular")
    void deberiaListarEstudiantesSinMatricula() throws Exception {

        mocMvc.perform(get("/matricula-estudiantes/estudiantes-sin-matricula")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(2)));

    }
}