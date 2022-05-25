package com.ceiba.estudiante.consulta;

import com.ceiba.estudiante.modelo.dto.DtoEstudiante;
import com.ceiba.estudiante.puerto.dao.DaoEstudiante;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarEstudiantePorId {

    private final DaoEstudiante daoEstudiante;

    public ManejadorListarEstudiantePorId(DaoEstudiante daoEstudiante) {
        this.daoEstudiante = daoEstudiante;
    }

    public DtoEstudiante ejecutar(Long idEstudiante) {
        return this.daoEstudiante.listarPorId(idEstudiante);
    }
}
