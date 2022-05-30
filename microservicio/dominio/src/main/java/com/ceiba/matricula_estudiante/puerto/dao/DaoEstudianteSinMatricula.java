package com.ceiba.matricula_estudiante.puerto.dao;

import com.ceiba.matricula_estudiante.modelo.dto.DtoEstudianteSinMatricula;
import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;

import java.util.List;


public interface DaoEstudianteSinMatricula {

    List<DtoEstudianteSinMatricula> listarEstudiantesSinMatricula();
}
