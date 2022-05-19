package com.ceiba.matricula_estudiante.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.estudiante.servicio.ServicioCrearEstudiante;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import com.ceiba.matricula_estudiante.puerto.repositorio.RepositorioMatriculaEstudiante;
import com.ceiba.matricula_estudiante.servicio.testdatabuilder.MatriculaEstudianteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearMatriculaEstudianteTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de una matricula")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeUnaMatricula() {

        MatriculaEstudiante matriculaEstudiante = new MatriculaEstudianteTestDataBuilder().build();
        RepositorioMatriculaEstudiante repositorioMatriculaEstudiante = Mockito.mock(RepositorioMatriculaEstudiante.class);
        Mockito.when(repositorioMatriculaEstudiante.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearMatriculaEstudiante servicioCrearMatriculaEstudiante = new ServicioCrearMatriculaEstudiante(repositorioMatriculaEstudiante);

        BasePrueba.assertThrows(() -> servicioCrearMatriculaEstudiante.ejecutar(matriculaEstudiante),
                ExcepcionDuplicidad.class,"El estudiante ya esta matriculado en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear la matricula de manera correcta")
    void deberiaCrearLaMatriculaDeManeraCorrecta() {

        MatriculaEstudiante matriculaEstudiante = new MatriculaEstudianteTestDataBuilder().build();
        RepositorioMatriculaEstudiante repositorioMatriculaEstudiante = Mockito.mock(RepositorioMatriculaEstudiante.class);
        Mockito.when(repositorioMatriculaEstudiante.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioMatriculaEstudiante.crear(matriculaEstudiante)).thenReturn(10L);
        ServicioCrearMatriculaEstudiante servicioCrearMatriculaEstudiante = new ServicioCrearMatriculaEstudiante(repositorioMatriculaEstudiante);

        Long idMatricula = servicioCrearMatriculaEstudiante.ejecutar(matriculaEstudiante);

        assertEquals(10L,idMatricula);
        Mockito.verify(repositorioMatriculaEstudiante, Mockito.times(1)).crear(matriculaEstudiante);
    }
}
