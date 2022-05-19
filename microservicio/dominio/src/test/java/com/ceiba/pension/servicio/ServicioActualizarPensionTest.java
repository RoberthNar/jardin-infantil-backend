package com.ceiba.pension.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.estudiante.servicio.ServicioActualizarEstudiante;
import com.ceiba.pension.modelo.entidad.Pension;
import com.ceiba.pension.puerto.repositorio.RepositorioPension;
import com.ceiba.pension.servicio.testdatabuilder.PensionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarPensionTest {

    @Test
    @DisplayName("Deberia validar la existencia previa de la pension del estudiante")
    void deberiaValidarLaExistenciaPreviaDeLaPensionDeLEstudiante() {

        Pension pension = new PensionTestDataBuilder().build();
        RepositorioPension repositorioPension = Mockito.mock(RepositorioPension.class);
        Mockito.when(repositorioPension.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarPension servicioActualizarPension = new ServicioActualizarPension(repositorioPension);
        BasePrueba.assertThrows(() -> servicioActualizarPension.ejecutar(pension), ExcepcionDuplicidad.class,
                "El estudiante no tiene una pension pagada");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {

        Pension pension = new PensionTestDataBuilder().conId(1L).build();
        RepositorioPension repositorioPension = Mockito.mock(RepositorioPension.class);
        Mockito.when(repositorioPension.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarPension servicioActualizarPension = new ServicioActualizarPension(repositorioPension);

        servicioActualizarPension.ejecutar(pension);

        Mockito.verify(repositorioPension, Mockito.times(1)).actualizar(pension);
    }

}
