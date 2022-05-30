package com.ceiba.matricula_estudiante.consulta;

import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;
import com.ceiba.matricula_estudiante.puerto.dao.DaoMatriculaEstudiante;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMatriculaEstudiantes {

    private final DaoMatriculaEstudiante daoMatriculaEstudiante;

    public ManejadorListarMatriculaEstudiantes(DaoMatriculaEstudiante daoMatriculaEstudiante) {
        this.daoMatriculaEstudiante = daoMatriculaEstudiante;
    }

    public List<DtoMatriculaEstudiante> ejecutar() {
        return this.daoMatriculaEstudiante.listar();
    }
}
