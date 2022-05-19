package com.ceiba.pension.servicio;

import com.ceiba.matricula_estudiante.comando.ComandoMatriculaEstudiante;
import com.ceiba.pension.comando.ComandoPension;

import java.time.LocalDate;

public class ComandoPensionTestDataBuilder {

    private Long id;
    private Long idEstudiante;
    private Integer horasMulta;
    private LocalDate mesPagado;
    private Double valorTotal;

    public ComandoPensionTestDataBuilder() {
        this.idEstudiante = 2L;
        this.horasMulta = 0;
        this.mesPagado = LocalDate.now();
        this.valorTotal = 350000D;
    }

    public ComandoPension build() {
        return new ComandoPension(id, idEstudiante, horasMulta, mesPagado, valorTotal);
    }
}
