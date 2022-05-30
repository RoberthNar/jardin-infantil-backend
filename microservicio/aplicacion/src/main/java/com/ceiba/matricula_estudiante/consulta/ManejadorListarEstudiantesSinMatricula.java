package com.ceiba.matricula_estudiante.consulta;

import com.ceiba.matricula_estudiante.modelo.dto.DtoEstudianteSinMatricula;
import com.ceiba.matricula_estudiante.puerto.dao.DaoEstudianteSinMatricula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEstudiantesSinMatricula {

    private final DaoEstudianteSinMatricula daoEstudianteSinMatricula;

    public ManejadorListarEstudiantesSinMatricula(DaoEstudianteSinMatricula daoEstudianteSinMatricula) {
        this.daoEstudianteSinMatricula = daoEstudianteSinMatricula;
    }

    public List<DtoEstudianteSinMatricula> ejecutar() {
        return this.daoEstudianteSinMatricula.listarEstudiantesSinMatricula();
    }
}
