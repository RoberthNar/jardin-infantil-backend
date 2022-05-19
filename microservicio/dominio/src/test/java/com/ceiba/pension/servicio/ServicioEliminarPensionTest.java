package com.ceiba.pension.servicio;

import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.estudiante.servicio.ServicioEliminarEstudiante;
import com.ceiba.pension.puerto.repositorio.RepositorioPension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarPensionTest {

    @Test
    @DisplayName("Deberia eliminar una pension el estudiante llamando al repositorio")
    void deberiaEliminarPensionDelEstudianteLlamandoAlRepositorio() {
        RepositorioPension repositorioPension = Mockito.mock(RepositorioPension.class);
        ServicioEliminarPension servicioEliminarPension = new ServicioEliminarPension(repositorioPension);

        servicioEliminarPension.ejecutar(1l);

        Mockito.verify(repositorioPension, Mockito.times(1)).eliminar(1l);

    }

}
