package com.ceiba.estudiante.puerto.dao;

import com.ceiba.estudiante.modelo.dto.DtoEstudiante;

import java.util.List;

public interface DaoEstudiante {

    List<DtoEstudiante> listarPorNombre(String nombreEstudiante);

    DtoEstudiante listarPorId(Long idEstudiante);

    List<DtoEstudiante> listar();

}
