package com.ceiba.pension.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pension.modelo.entidad.Pension;
import com.ceiba.pension.puerto.repositorio.RepositorioPension;
import com.ceiba.pension.servicio.testdatabuilder.PensionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPensionTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de una pension")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeUnaPension() {

        Pension pension = new PensionTestDataBuilder().conId(1L).build();
        RepositorioPension repositorioPension = Mockito.mock(RepositorioPension.class);
        Mockito.when(repositorioPension.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearPension servicioCrearPension = new ServicioCrearPension(repositorioPension);

        BasePrueba.assertThrows(() -> servicioCrearPension.ejecutar(pension),
                ExcepcionDuplicidad.class,"El estudiante ya pago pension");
    }

    @Test
    @DisplayName("Deberia Crear una pension de manera correcta")
    void deberiaCrearElEstudianteDeManeraCorrecta() {

        Pension pension = new PensionTestDataBuilder().build();
        RepositorioPension repositorioPension = Mockito.mock(RepositorioPension.class);
        Mockito.when(repositorioPension.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPension.crear(pension)).thenReturn(10L);
        ServicioCrearPension servicioCrearPension = new ServicioCrearPension(repositorioPension);

        Long idPension = servicioCrearPension.ejecutar(pension);

        assertEquals(10L,idPension);
        Mockito.verify(repositorioPension, Mockito.times(1)).crear(pension);
    }
}
