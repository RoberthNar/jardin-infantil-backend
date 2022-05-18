package com.ceiba.matricula_estudiante.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import com.ceiba.matricula_estudiante.puerto.repositorio.RepositorioMatriculaEstudiante;

public class ServicioActualizarMatriculaEstudiante {

    private static final String El_ESTUDIANTE_NO_ESTA_MATRICULADO = "El estudiante no esta matriculado";

    private final RepositorioMatriculaEstudiante repositorioMatriculaEstudiante;

    public ServicioActualizarMatriculaEstudiante(RepositorioMatriculaEstudiante repositorioMatriculaEstudiante) {
        this.repositorioMatriculaEstudiante = repositorioMatriculaEstudiante;
    }

    public void ejecutar(MatriculaEstudiante matriculaEstudiante) {
        validarExistenciaPrevia(matriculaEstudiante);
        this.repositorioMatriculaEstudiante.actualizar(matriculaEstudiante);
    }

    private void validarExistenciaPrevia(MatriculaEstudiante matriculaEstudiante) {
        boolean existe = this.repositorioMatriculaEstudiante.existePorId(matriculaEstudiante.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(El_ESTUDIANTE_NO_ESTA_MATRICULADO);
        }
    }

}
