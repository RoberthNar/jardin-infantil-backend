package com.ceiba.matricula_estudiante.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import com.ceiba.matricula_estudiante.servicio.testdatabuilder.MatriculaEstudianteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatriculaEstudianteTest {

    @Test
    @DisplayName("Deberia crear correctamente la matricula del estudiante")
    void deberiaCrearCorrectamenteLaMatriculaDelEstudiante() {

        MatriculaEstudiante matriculaEstudiante = new MatriculaEstudianteTestDataBuilder().build();

        assertEquals(1, matriculaEstudiante.getIdEstudiante());
        assertEquals(1, matriculaEstudiante.getIdDocenteSala());
        assertEquals("Completa", matriculaEstudiante.getJornada());
        assertEquals(LocalDate.now(), matriculaEstudiante.getFechaIngreso());
    }

    @Test
    @DisplayName("Deberia fallar la creacion sin identificador del estudiante")
    void deberiaFallarSinIdentificacionDeEstudiante() {

        MatriculaEstudianteTestDataBuilder matriculaEstudianteTestDataBuilder = new MatriculaEstudianteTestDataBuilder().conIdEstudiante(null);

        BasePrueba.assertThrows(() -> {
                    matriculaEstudianteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar los datos del estudiante");
    }

    @Test
    @DisplayName("Deberia fallar la creacion sin identificador de la sala")
    void deberiaFallarSinIdentificacionDeSala() {

        MatriculaEstudianteTestDataBuilder matriculaEstudianteTestDataBuilder =
                new MatriculaEstudianteTestDataBuilder().conIdDocenteSala(null);

        BasePrueba.assertThrows(() -> {
                    matriculaEstudianteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar los datos del salón del estudiante");
    }

    @Test
    @DisplayName("Deberia fallar la creacion sin jornada del estudiante")
    void deberiaFallarSinJornadaDeEstudiante() {

        MatriculaEstudianteTestDataBuilder matriculaEstudianteTestDataBuilder =
                new MatriculaEstudianteTestDataBuilder().conJornada(null);

        BasePrueba.assertThrows(() -> {
                    matriculaEstudianteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la jornada del estudiante");
    }



    @Test
    @DisplayName("Deberia fallar la creacion sin fecha de ingreso")
    void deberiaFallarSinFechaDeIngresoDeEstudiante() {

        MatriculaEstudianteTestDataBuilder matriculaEstudianteTestDataBuilder =
                new MatriculaEstudianteTestDataBuilder().conFechaIngreso(null);
        BasePrueba.assertThrows(() -> {
                    matriculaEstudianteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de ingreso del estudiante");
    }

    @Test
    @DisplayName("Deberia fallar la creacion cuando la jornada no es correcta")
    void deberiaFallarCuandoLaJornadaNoEsCorrecta() {

        String jornada = "AAAAA";
        MatriculaEstudianteTestDataBuilder matriculaEstudianteTestDataBuilder =
                new MatriculaEstudianteTestDataBuilder().conJornada(jornada);
        BasePrueba.assertThrows(() -> {
                    matriculaEstudianteTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar una jornada correcta");
    }

    @Test
    @DisplayName("Deberia fallar la creacion cuando el dia no es habil")
    void deberiaFallarCuandoElDiaNoEsHabil() {

        LocalDate fecha = LocalDate.parse("2022-05-29");
        MatriculaEstudianteTestDataBuilder matriculaEstudianteTestDataBuilder =
                new MatriculaEstudianteTestDataBuilder().conFechaIngreso(fecha);
        BasePrueba.assertThrows(() -> {
                    matriculaEstudianteTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La fecha no puede ser igual a un dia de descanso");
    }

    @Test
    @DisplayName("Deberia fallar la creacion cuando la fecha es menor a la fecha actual")
    void deberiaFallarCuandoLafechaEsMenosAlDiaActual() {

        LocalDate fecha = LocalDate.parse("2022-04-26");
        MatriculaEstudianteTestDataBuilder matriculaEstudianteTestDataBuilder =
                new MatriculaEstudianteTestDataBuilder().conFechaIngreso(fecha);
        BasePrueba.assertThrows(() -> {
                    matriculaEstudianteTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La fecha no puede ser menor al dia de actual");
    }
}
