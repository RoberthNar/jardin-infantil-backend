package com.ceiba.pension.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.pension.modelo.entidad.Pension;
import com.ceiba.pension.puerto.repositorio.RepositorioPension;

public class ServicioCrearPension {

    private static final String EL_ESTUDIANTE_YA_EXISTE_PAGO_PENSION = "El estudiante ya pago pension";

    private final RepositorioPension repositorioPension;

    public ServicioCrearPension(RepositorioPension repositorioPension) {
        this.repositorioPension = repositorioPension;
    }

    public Long ejecutar(Pension pension) {
        validarExistenciaPrevia(pension);
        return this.repositorioPension.crear(pension);
    }

    private void validarExistenciaPrevia(Pension pension) {
        boolean existe = this.repositorioPension.existePorId(pension.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_ESTUDIANTE_YA_EXISTE_PAGO_PENSION);
        }
    }

}
