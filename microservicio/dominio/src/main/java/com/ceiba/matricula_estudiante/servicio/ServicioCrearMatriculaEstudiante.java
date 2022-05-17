package com.ceiba.matricula_estudiante.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import com.ceiba.matricula_estudiante.puerto.repositorio.RepositorioMatriculaEstudiante;

public class ServicioCrearMatriculaEstudiante {

    private static final String EL_ESTUDIANTE_YA_ESTA_MATRICULADO_EN_EL_SISTEMA = "El estudiante ya esta matriculado en el sistema";

    private final RepositorioMatriculaEstudiante repositorioMatriculaEstudiante;

    public ServicioCrearMatriculaEstudiante(RepositorioMatriculaEstudiante repositorioMatriculaEstudiante) {
        this.repositorioMatriculaEstudiante = repositorioMatriculaEstudiante;
    }

    public Long ejecutar(MatriculaEstudiante matriculaEstudiante) {
        validarExistenciaPrevia(matriculaEstudiante);
        return this.repositorioMatriculaEstudiante.crear(matriculaEstudiante);
    }

    private void validarExistenciaPrevia(MatriculaEstudiante matriculaEstudiante) {
        boolean existe = this.repositorioMatriculaEstudiante.existePorId(matriculaEstudiante.getIdEstudiante());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_ESTUDIANTE_YA_ESTA_MATRICULADO_EN_EL_SISTEMA);
        }
    }

}
