package com.ceiba.estudiante.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;

public class ServicioCrearEstudiante {

    private static final String EL_ESTUDIANTE_YA_EXISTE_EN_EL_SISTEMA = "El estudiante ya existe en el sistema";

    private final RepositorioEstudiante repositorioEstudiante;

    public ServicioCrearEstudiante(RepositorioEstudiante repositorioEstudiante) {
        this.repositorioEstudiante = repositorioEstudiante;
    }

    public Long ejecutar(Estudiante estudiante) {
        validarExistenciaPrevia(estudiante);
        return this.repositorioEstudiante.crear(estudiante);
    }

    private void validarExistenciaPrevia(Estudiante estudiante) {
        boolean existe = this.repositorioEstudiante.existe(estudiante.getNombreEstudiante());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_ESTUDIANTE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
