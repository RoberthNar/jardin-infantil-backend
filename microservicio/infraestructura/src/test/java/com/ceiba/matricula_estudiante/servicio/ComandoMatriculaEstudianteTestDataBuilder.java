package com.ceiba.matricula_estudiante.servicio;

import com.ceiba.estudiante.comando.ComandoEstudiante;
import com.ceiba.matricula_estudiante.comando.ComandoMatriculaEstudiante;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoMatriculaEstudianteTestDataBuilder {

    private Long id;
    private Long idEstudiante;
    private Long idDocenteSala;
    private String jornada;
    private LocalDate fechaIngreso;

    public ComandoMatriculaEstudianteTestDataBuilder() {
        this.idEstudiante = 2L;
        this.idDocenteSala = 1L;
        this.jornada = "Completa";
        this.fechaIngreso = LocalDate.now();
    }

    public ComandoMatriculaEstudiante build() {
        return new ComandoMatriculaEstudiante(id, idEstudiante, idDocenteSala, jornada, fechaIngreso);
    }
}
