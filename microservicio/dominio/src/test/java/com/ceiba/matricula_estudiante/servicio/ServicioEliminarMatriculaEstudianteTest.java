package com.ceiba.matricula_estudiante.servicio;

import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.estudiante.servicio.ServicioEliminarEstudiante;
import com.ceiba.matricula_estudiante.puerto.repositorio.RepositorioMatriculaEstudiante;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarMatriculaEstudianteTest {

    @Test
    @DisplayName("Deberia eliminar la matricula llamando al repositorio")
    void deberiaEliminarLaMatriculaLlamandoAlRepositorio() {
        RepositorioMatriculaEstudiante repositorioMatriculaEstudiante = Mockito.mock(RepositorioMatriculaEstudiante.class);
        ServicioEliminarMatriculaEstudiante servicioEliminarMatriculaEstudiante =
                new ServicioEliminarMatriculaEstudiante(repositorioMatriculaEstudiante);

        servicioEliminarMatriculaEstudiante.ejecutar(1l);

        Mockito.verify(repositorioMatriculaEstudiante, Mockito.times(1)).eliminar(1l);

    }

}
