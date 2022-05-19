package com.ceiba.matricula_estudiante.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.estudiante.servicio.ServicioActualizarEstudiante;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import com.ceiba.matricula_estudiante.puerto.repositorio.RepositorioMatriculaEstudiante;
import com.ceiba.matricula_estudiante.servicio.testdatabuilder.MatriculaEstudianteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarMatriculaEstudianteTest {

    @Test
    @DisplayName("Deberia validar la existencia previa de la matricula del estudiante")
    void deberiaValidarLaExistenciaPreviaDeLaMatriculaEstudiante() {

        MatriculaEstudiante matriculaEstudiante = new MatriculaEstudianteTestDataBuilder().build();
        RepositorioMatriculaEstudiante repositorioMatriculaEstudiante = Mockito.mock(RepositorioMatriculaEstudiante.class);
        Mockito.when(repositorioMatriculaEstudiante.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarMatriculaEstudiante servicioActualizarMatriculaEstudiante =
                new ServicioActualizarMatriculaEstudiante(repositorioMatriculaEstudiante);
        BasePrueba.assertThrows(() -> servicioActualizarMatriculaEstudiante.ejecutar(matriculaEstudiante),
                ExcepcionDuplicidad.class, "El estudiante no esta matriculado");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {

        MatriculaEstudiante matriculaEstudiante = new MatriculaEstudianteTestDataBuilder().conId(1L).build();
        RepositorioMatriculaEstudiante repositorioMatriculaEstudiante = Mockito.mock(RepositorioMatriculaEstudiante.class);
        Mockito.when(repositorioMatriculaEstudiante.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarMatriculaEstudiante servicioActualizarMatriculaEstudiante =
                new ServicioActualizarMatriculaEstudiante(repositorioMatriculaEstudiante);

        servicioActualizarMatriculaEstudiante.ejecutar(matriculaEstudiante);

        Mockito.verify(repositorioMatriculaEstudiante, Mockito.times(1)).actualizar(matriculaEstudiante);
    }

}
