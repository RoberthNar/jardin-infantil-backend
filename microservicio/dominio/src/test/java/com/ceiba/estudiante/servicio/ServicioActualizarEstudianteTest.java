package com.ceiba.estudiante.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioActualizarEstudianteTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del estudiante")
    void deberiaValidarLaExistenciaPreviaDeLEstudiante() {

        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        RepositorioEstudiante repositorioEstudiante = Mockito.mock(RepositorioEstudiante.class);
        Mockito.when(repositorioEstudiante.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarEstudiante servicioActualizarEstudiante = new ServicioActualizarEstudiante(repositorioEstudiante);
        BasePrueba.assertThrows(() -> servicioActualizarEstudiante.ejecutar(estudiante), ExcepcionDuplicidad.class, "El estudiante no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {

        Estudiante estudiante = new EstudianteTestDataBuilder().conId(1L).build();
        RepositorioEstudiante repositorioEstudiante = Mockito.mock(RepositorioEstudiante.class);
        Mockito.when(repositorioEstudiante.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarEstudiante servicioActualizarEstudiante = new ServicioActualizarEstudiante(repositorioEstudiante);

        servicioActualizarEstudiante.ejecutar(estudiante);

        Mockito.verify(repositorioEstudiante, Mockito.times(1)).actualizar(estudiante);
    }

}
