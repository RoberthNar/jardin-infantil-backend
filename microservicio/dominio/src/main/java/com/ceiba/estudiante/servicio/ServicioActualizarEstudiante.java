package com.ceiba.estudiante.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;

public class ServicioActualizarEstudiante {

    private static final String El_ESTUDIANTE_NO_EXISTE_EN_EL_SISTEMA = "El estudiante no existe en el sistema";

    private final RepositorioEstudiante repositorioEstudiante;

    public ServicioActualizarEstudiante(RepositorioEstudiante repositorioEstudiante) {
        this.repositorioEstudiante = repositorioEstudiante;
    }

    public void ejecutar(Estudiante estudiante) {
        validarExistenciaPrevia(estudiante);
        this.repositorioEstudiante.actualizar(estudiante);
    }

    private void validarExistenciaPrevia(Estudiante estudiante) {
        boolean existe = this.repositorioEstudiante.existePorId(estudiante.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(El_ESTUDIANTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
