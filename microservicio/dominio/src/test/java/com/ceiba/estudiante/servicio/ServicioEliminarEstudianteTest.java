package com.ceiba.estudiante.servicio;

import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.estudiante.servicio.ServicioEliminarEstudiante;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

public class ServicioEliminarEstudianteTest {

    @Test
    @DisplayName("Deberia eliminar la Cancha llamando al repositorio")
    void deberiaEliminarLaCanchaLlamandoAlRepositorio() {
        RepositorioEstudiante repositorioEstudiante = Mockito.mock(RepositorioEstudiante.class);
        ServicioEliminarEstudiante servicioEliminarEstudiante = new ServicioEliminarEstudiante(repositorioEstudiante);

        servicioEliminarEstudiante.ejecutar(1l);

        Mockito.verify(repositorioEstudiante, Mockito.times(1)).eliminar(1l);

    }

}
