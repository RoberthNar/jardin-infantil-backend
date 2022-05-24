package com.ceiba.estudiante.consulta;

import com.ceiba.estudiante.modelo.dto.DtoEstudiante;
import com.ceiba.estudiante.puerto.dao.DaoEstudiante;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEstudiantePorNombre {

    private final DaoEstudiante daoEstudiante;

    public ManejadorListarEstudiantePorNombre(DaoEstudiante daoEstudiante) {
        this.daoEstudiante = daoEstudiante;
    }

    public List<DtoEstudiante> ejecutar(String nombreEstudiante) {
        return this.daoEstudiante.listarPorNombre(nombreEstudiante);
    }
}
