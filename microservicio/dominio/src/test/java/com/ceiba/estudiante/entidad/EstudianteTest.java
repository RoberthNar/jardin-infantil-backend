package com.ceiba.estudiante.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstudianteTest {

    @Test
    @DisplayName("Deberia crear correctamente el estudiante")
    void deberiaCrearCorrectamenteElEstudiante() {

        Estudiante estudiante = new EstudianteTestDataBuilder().build();

        assertEquals("Estudiante Test 1", estudiante.getNombreEstudiante());
        assertEquals(LocalDate.now().plusMonths(-9), estudiante.getFechaNacimiento());
        assertEquals("Acudiente Test 1", estudiante.getNombreAcudiente());
    }

    @Test
    @DisplayName("Deberia fallar la creacion sin nombre del estudiante")
    void deberiaFallarSinNombreDeEstudiante() {

        EstudianteTestDataBuilder estudianteTestDataBuilder = new EstudianteTestDataBuilder().conNombreEstudiante(null);

        BasePrueba.assertThrows(() -> {
                    estudianteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del estudiante");
    }

    @Test
    @DisplayName("Deberia fallar la creacion sin fecha de nacimiento")
    void deberiaFallarSinFechaDeNacimientoDeEstudiante() {

        EstudianteTestDataBuilder estudianteTestDataBuilder = new EstudianteTestDataBuilder().conFechaNacimiento(null);
        BasePrueba.assertThrows(() -> {
                    estudianteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la feha de nacimiento del estudiante");
    }

    @Test
    @DisplayName("Deberia fallar la creacion sin nombre de acudiente")
    void deberiaFallarSinNombreDeAcudiente() {

        EstudianteTestDataBuilder estudianteTestDataBuilder = new EstudianteTestDataBuilder().conNombreAcudiente(null);
        BasePrueba.assertThrows(() -> {
                    estudianteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del acudiente");
    }

    @Test
    @DisplayName("Deberia fallar cuando el estudiante tiene menos de 8 meses de edad")
    void deberiaFallarCuandoElEstudianteEsMenorDeOchoMeses() {

        LocalDate fechaNacimiento = LocalDate.now();
        EstudianteTestDataBuilder estudianteTestDataBuilder = new EstudianteTestDataBuilder().conFechaNacimiento(fechaNacimiento);
        BasePrueba.assertThrows(() -> {
                    estudianteTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "El estudiante no puede ser menor a 8 meses de edad");
    }

    @Test
    @DisplayName("Deberia fallar cuando el estudiante tiene mas de 5 anios de edad")
    void deberiaFallarCuandoElEstudianteEsMayorDeCincoAnios() {

        LocalDate fechaNacimiento = LocalDate.parse("2000-01-26");
        EstudianteTestDataBuilder estudianteTestDataBuilder = new EstudianteTestDataBuilder().conFechaNacimiento(fechaNacimiento);
        BasePrueba.assertThrows(() -> {
                    estudianteTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "El estudiante no puede ser mayor a 5 anios de edad");
    }
}
