package com.ceiba.estudiante.consulta;

import com.ceiba.estudiante.modelo.dto.DtoEstudiante;
import com.ceiba.estudiante.puerto.dao.DaoEstudiante;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEstudiantePorId {

    private final DaoEstudiante daoEstudiante;

    public ManejadorListarEstudiantePorId(DaoEstudiante daoEstudiante) {
        this.daoEstudiante = daoEstudiante;
    }

    public List<DtoEstudiante> ejecutar(Long idEstudiante) {
        return this.daoEstudiante.listarPorId(idEstudiante);
    }
}
