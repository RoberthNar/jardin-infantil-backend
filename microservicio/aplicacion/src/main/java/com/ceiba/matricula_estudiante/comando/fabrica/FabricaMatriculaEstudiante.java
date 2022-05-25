package com.ceiba.matricula_estudiante.comando.fabrica;

import com.ceiba.estudiante.modelo.dto.DtoEstudiante;
import com.ceiba.estudiante.puerto.dao.DaoEstudiante;
import com.ceiba.matricula_estudiante.comando.ComandoMatriculaEstudiante;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class FabricaMatriculaEstudiante {

    private static final long SALA_CUNA = 1;
    private static final long SALA_PARBULOS = 3;
    private static final long SALA_PREJARDIN = 4;
    private static final long SALA_JARDIN = 5;

    private final DaoEstudiante daoEstudiante;

    public FabricaMatriculaEstudiante(DaoEstudiante daoEstudiante) {
        this.daoEstudiante = daoEstudiante;
    }


    public MatriculaEstudiante crear(ComandoMatriculaEstudiante comandoMatriculaEstudiante) {
        return new MatriculaEstudiante(comandoMatriculaEstudiante.getId(),
                comandoMatriculaEstudiante.getIdEstudiante(),
                agregarSalaEstudiante(comandoMatriculaEstudiante.getIdEstudiante()),
                comandoMatriculaEstudiante.getJornada(),
                comandoMatriculaEstudiante.getFechaIngreso());
    }

    private Long agregarSalaEstudiante(Long id) {
        long edad = obtenerEdadEstudiante(id);
        long sala = 0L;

        if (edad < 1) {
            sala = SALA_CUNA;
        } else if (edad <= 2) {
            sala = SALA_PARBULOS;
        } else if (edad <= 3) {
           sala = SALA_PREJARDIN;
        } else if (edad <= 4) {
            sala = SALA_JARDIN;
        }
        return sala;
    }

    private long obtenerEdadEstudiante(Long id) {
        DtoEstudiante estudiante = this.daoEstudiante.listarPorId(id);
        return ChronoUnit.YEARS.between(estudiante.getFechaNacimiento(), LocalDate.now());
    }
}
