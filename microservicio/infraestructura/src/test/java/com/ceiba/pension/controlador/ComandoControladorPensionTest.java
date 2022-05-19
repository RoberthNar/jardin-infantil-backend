package com.ceiba.pension.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.estudiante.controlador.ComandoControladorEstudiante;
import com.ceiba.pension.comando.ComandoPension;
import com.ceiba.pension.servicio.ComandoPensionTestDataBuilder;
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
class ComandoControladorPensionTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una pension estudiante")
    void deberiaCrearUnaPensionEstudiante() throws Exception {

        ComandoPension pension = new ComandoPensionTestDataBuilder().build();

        mocMvc.perform(post("/calculo-pensiones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pension)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar los datos de una pension")
    void deberiaActualizarUnaPensionEstudiante() throws Exception {

        Long id = 1L;
        ComandoPension comandoPension = new ComandoPensionTestDataBuilder().build();

        mocMvc.perform(put("/calculo-pensiones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoPension)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar una pension de un estudiante")
    void deberiaEliminarUnaPensionEstudiante() throws Exception {

        Long id = 2L;
        mocMvc.perform(delete("/calculo-pensiones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}