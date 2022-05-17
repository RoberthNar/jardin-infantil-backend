package com.ceiba.estudiante.matricula_estudiante.servicio;

import com.ceiba.estudiante.matricula_estudiante.puerto.repositorio.RepositorioMatriculaEstudiante;

public class ServicioEliminarMatriculaEstudiante {

    private final RepositorioMatriculaEstudiante repositorioMatriculaEstudiante;

    public ServicioEliminarMatriculaEstudiante(RepositorioMatriculaEstudiante repositorioMatriculaEstudiante) {
        this.repositorioMatriculaEstudiante = repositorioMatriculaEstudiante;
    }

    public void ejecutar(Long id) {
        this.repositorioMatriculaEstudiante.eliminar(id);
    }

}
