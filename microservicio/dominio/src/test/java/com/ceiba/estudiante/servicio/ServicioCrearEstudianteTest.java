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

public class ServicioCrearEstudianteTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de un estudiante")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeUnEstudiante() {

        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        RepositorioEstudiante repositorioEstudiante = Mockito.mock(RepositorioEstudiante.class);
        Mockito.when(repositorioEstudiante.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearEstudiante servicioCrearEstudiante = new ServicioCrearEstudiante(repositorioEstudiante);

        BasePrueba.assertThrows(() -> servicioCrearEstudiante.ejecutar(estudiante),
                ExcepcionDuplicidad.class,"El estudiante ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el Estudinte de manera correcta")
    void deberiaCrearElEstudianteDeManeraCorrecta() {

        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        RepositorioEstudiante repositorioEstudiante = Mockito.mock(RepositorioEstudiante.class);
        Mockito.when(repositorioEstudiante.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioEstudiante.crear(estudiante)).thenReturn(10L);
        ServicioCrearEstudiante servicioCrearEstudiante = new ServicioCrearEstudiante(repositorioEstudiante);

        Long idCancha = servicioCrearEstudiante.ejecutar(estudiante);

        assertEquals(10L,idCancha);
        Mockito.verify(repositorioEstudiante, Mockito.times(1)).crear(estudiante);
    }
}
