package com.ceiba.matricula_estudiante.puerto.dao;

import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;


public interface DaoMatriculaEstudiante {

    DtoMatriculaEstudiante listarPorIdEstudiante(Long idEstudiante);

}
