package com.ceiba.pension.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.pension.modelo.entidad.Pension;
import com.ceiba.pension.servicio.testdatabuilder.PensionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PensionTest {

    @Test
    @DisplayName("Deberia crear correctamente la Pension")
    void deberiaCrearCorrectamenteLaPension() {

        Pension pension = new PensionTestDataBuilder().build();

        assertEquals(1, pension.getIdEstudiante());
        assertEquals(0, pension.getHorasMulta());
        assertEquals(LocalDate.now().plusMonths(1), pension.getMesPagado());
        assertEquals(350000, pension.getValorTotal());
    }

    @Test
    @DisplayName("Deberia fallar la creacion sin id del estudiante")
    void deberiaFallarSinIdDeEstudiante() {

        PensionTestDataBuilder pensionTestDataBuilder = new PensionTestDataBuilder().conIdEstudiante(null);

        BasePrueba.assertThrows(() -> {
                    pensionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el ID del estudiante");
    }

    @Test
    @DisplayName("Deberia fallar la creacion sin mes de pension")
    void deberiaFallarSinFechaDePension() {

        PensionTestDataBuilder pensionTestDataBuilder = new PensionTestDataBuilder().conMesPagado(null);
        BasePrueba.assertThrows(() -> {
                    pensionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el mes de pension a pagar");
    }

}
