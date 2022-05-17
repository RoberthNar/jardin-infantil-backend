package com.ceiba.pension.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.pension.modelo.entidad.Pension;
import com.ceiba.pension.puerto.repositorio.RepositorioPension;

public class ServicioActualizarPension {

    private static final String El_ESTUDIANTE_NO_TIENE_UNA_PENSION_PAGADA = "El estudiante no tiene una pension pagada";

    private final RepositorioPension repositorioPension;

    public ServicioActualizarPension(RepositorioPension repositorioPension) {
        this.repositorioPension = repositorioPension;
    }

    public void ejecutar(Pension pension) {
        validarExistenciaPrevia(pension);
        this.repositorioPension.actualizar(pension);
    }

    private void validarExistenciaPrevia(Pension pension) {
        boolean existe = this.repositorioPension.existePorId(pension.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(El_ESTUDIANTE_NO_TIENE_UNA_PENSION_PAGADA);
        }
    }

}
