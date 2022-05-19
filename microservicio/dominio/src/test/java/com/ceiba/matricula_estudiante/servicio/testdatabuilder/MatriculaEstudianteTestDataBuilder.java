package com.ceiba.matricula_estudiante.servicio.testdatabuilder;

import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;

import java.time.LocalDate;

public class MatriculaEstudianteTestDataBuilder {

    private Long id;
    private Long idEstudiante;
    private Long idDocenteSala;
    private String jornada;
    private LocalDate fechaIngreso;


    public MatriculaEstudianteTestDataBuilder() {
        this.idEstudiante = 1L;
        this.idDocenteSala = 1L;
        this.jornada = "Completa";
        this.fechaIngreso = LocalDate.now();
    }

    public MatriculaEstudianteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public MatriculaEstudianteTestDataBuilder conIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
        return this;
    }

    public MatriculaEstudianteTestDataBuilder conIdDocenteSala(Long idDocenteSala) {
        this.idDocenteSala = idDocenteSala;
        return this;
    }

    public MatriculaEstudianteTestDataBuilder conJornada(String jornada) {
        this.jornada = jornada;
        return this;
    }

    public MatriculaEstudianteTestDataBuilder conFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public MatriculaEstudiante build() {
        return new MatriculaEstudiante(id, idEstudiante, idDocenteSala, jornada, fechaIngreso);
    }
}
