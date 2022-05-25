package com.ceiba.matricula_estudiante.consulta;

import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;
import com.ceiba.matricula_estudiante.puerto.dao.DaoMatriculaEstudiante;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarMatriculaEstudiantePorIdEstudiante {

    private final DaoMatriculaEstudiante daoMatriculaEstudiante;

    public ManejadorListarMatriculaEstudiantePorIdEstudiante(DaoMatriculaEstudiante daoMatriculaEstudiante) {
        this.daoMatriculaEstudiante = daoMatriculaEstudiante;
    }

    public DtoMatriculaEstudiante ejecutar(Long idEstudiante) {
        return this.daoMatriculaEstudiante.listarPorIdEstudiante(idEstudiante);
    }
}
