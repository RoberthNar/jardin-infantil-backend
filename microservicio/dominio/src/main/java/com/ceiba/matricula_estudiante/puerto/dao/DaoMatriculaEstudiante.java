package com.ceiba.matricula_estudiante.puerto.dao;

import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;

import java.util.List;


public interface DaoMatriculaEstudiante {

    DtoMatriculaEstudiante listarPorIdEstudiante(Long idEstudiante);

    List<DtoMatriculaEstudiante> listar();
}
