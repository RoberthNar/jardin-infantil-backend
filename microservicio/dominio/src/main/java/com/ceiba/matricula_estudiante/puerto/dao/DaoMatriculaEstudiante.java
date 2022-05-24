package com.ceiba.matricula_estudiante.puerto.dao;

import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;

import java.util.List;

public interface DaoMatriculaEstudiante {

    List<DtoMatriculaEstudiante> listarPorIdEstudiante(Long idEstudiante);

}
