package com.ceiba.matricula_estudiante.comando.fabrica;

import com.ceiba.matricula_estudiante.comando.ComandoMatriculaEstudiante;
import com.ceiba.estudiante.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import org.springframework.stereotype.Component;

@Component
public class FabricaMatriculaEstudiante {

    public MatriculaEstudiante crear(ComandoMatriculaEstudiante comandoMatriculaEstudiante) {
        return new MatriculaEstudiante(comandoMatriculaEstudiante.getId(),
                comandoMatriculaEstudiante.getIdEstudiante(),
                comandoMatriculaEstudiante.getIdDocenteSala(),
                comandoMatriculaEstudiante.getJornada(),
                comandoMatriculaEstudiante.getFechaIngreso());
    }
}
