package com.ceiba.estudiante.matricula_estudiante.puerto.repositorio;

import com.ceiba.estudiante.matricula_estudiante.modelo.entidad.MatriculaEstudiante;

public interface RepositorioMatriculaEstudiante {

    Long crear(MatriculaEstudiante matriculaEstudiante);

    void actualizar(MatriculaEstudiante matriculaEstudiante);

    void eliminar(Long id);

    boolean existePorId(Long id);
}
