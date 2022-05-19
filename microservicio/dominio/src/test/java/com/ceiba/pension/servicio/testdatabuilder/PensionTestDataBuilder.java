package com.ceiba.pension.servicio.testdatabuilder;

import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.pension.modelo.entidad.Pension;

import java.time.LocalDate;

public class PensionTestDataBuilder {

    private Long id;
    private Long idEstudiante;
    private Integer horasMulta;
    private LocalDate mesPagado;
    private Double valorTotal;


    public PensionTestDataBuilder() {
        this.idEstudiante = 1L;
        this.horasMulta = 0;
        this.mesPagado = LocalDate.now().plusMonths(1);
        this.valorTotal = 350000D;
    }

    public PensionTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PensionTestDataBuilder conIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
        return this;
    }

    public PensionTestDataBuilder conHorasMulta(Integer horasMulta) {
        this.horasMulta = horasMulta;
        return this;
    }

    public PensionTestDataBuilder conMesPagado(LocalDate mesPagado) {
        this.mesPagado = mesPagado;
        return this;
    }

    public Pension build() {
        return new Pension(id, idEstudiante, horasMulta, mesPagado, valorTotal);
    }
}
